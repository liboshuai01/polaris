package com.liboshuai.mall.tiny.module.ums.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.liboshuai.mall.tiny.common.constants.RedisConstant;
import com.liboshuai.mall.tiny.common.constants.ShiroConstant;
import com.liboshuai.mall.tiny.common.enums.ResponseCode;
import com.liboshuai.mall.tiny.common.enums.UserStatusEnum;
import com.liboshuai.mall.tiny.compone.response.ResponseResult;
import com.liboshuai.mall.tiny.module.ums.domain.entity.UmsAdmin;
import com.liboshuai.mall.tiny.module.ums.domain.dto.UmsAdminDTO;
import com.liboshuai.mall.tiny.module.ums.domain.vo.UmsAdminVO;
import com.liboshuai.mall.tiny.module.ums.service.UmsAdminService;
import com.liboshuai.mall.tiny.shiro.cache.RedisClient;
import com.liboshuai.mall.tiny.shiro.jwt.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.Objects;

/**
 * @Author: liboshuai
 * @Date: 2022-09-10 01:27
 * @Description: 用户登录controller
 */
@Api(tags = "用户登录入口", value = "LoginAdminController")
@Slf4j
@RestController
public class LoginAdminController {

    @Value("${config.refreshToken-expireTime}")
    private String refreshTokenExpireTime;

    @Autowired
    private RedisClient redis;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UmsAdminService umsAdminService;


    /**
     * 用户注册
     */
    @ApiOperation(value = "注册", httpMethod = "POST")
    @PostMapping("/register")
    public ResponseResult<?> register(@RequestBody UmsAdminVO umsAdminVo) {
        UmsAdminDTO umsAdminDTO = new UmsAdminDTO();
        BeanUtils.copyProperties(umsAdminVo, umsAdminDTO);
        String username = umsAdminDTO.getUsername();
        String password = umsAdminDTO.getPassword();
        if (Objects.nonNull(password)) {
            int saltCount = ShiroConstant.HASH_INTERATIONS;
            String salt = ByteSource.Util.bytes(username).toString();
            String enPassword = new SimpleHash(ShiroConstant.ALGORITH_NAME, password,
                    salt, saltCount).toString();
            umsAdminDTO.setPassword(enPassword);
            umsAdminDTO.setSalt(salt);
            umsAdminDTO.setSaltCount(saltCount);
        }
        umsAdminDTO.setStatus(UserStatusEnum.Enable.getCode());
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminDTO, umsAdmin);
        log.info("日志umsAdmin:{}", JSONObject.toJSONString(umsAdmin));
        umsAdminService.save(umsAdmin);
        return ResponseResult.success("注册成功");
    }


    /**
     * 用户登录
     */
    @ApiOperation(value = "登录", httpMethod = "POST")
    @PostMapping("/login")
    public ResponseResult<?> login(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return ResponseResult.fail(ResponseCode.USERNAME_PASSWORD_NULL);
        }
        UmsAdminDTO umsAdminDTO = umsAdminService.findByUserName(username);
        // todo: 临时日志，待删除
        log.info("umsAdminDTO等于：{}", JSONObject.toJSONString(umsAdminDTO));
        if (Objects.isNull(umsAdminDTO)) {
            return ResponseResult.fail(ResponseCode.INCORRECT_CREDENTIALS);
        }
        if (Objects.isNull(umsAdminDTO.getSalt()) || Objects.isNull(umsAdminDTO.getSaltCount())) {
            return ResponseResult.fail(ResponseCode.SALT_IS_NOT_EXISTED);
        }
        String enPassword = new SimpleHash(ShiroConstant.ALGORITH_NAME, password,
                umsAdminDTO.getSalt(), umsAdminDTO.getSaltCount()).toString();
        if (!Objects.equals(umsAdminDTO.getPassword(), enPassword)) {
            return ResponseResult.fail(ResponseCode.INCORRECT_CREDENTIALS);
        }
        // 清除可能存在的shiro权限信息缓存
        if (redis.hasKey(RedisConstant.PREFIX_SHIRO_CACHE + username)) {
            redis.del(RedisConstant.PREFIX_SHIRO_CACHE + username);
        }
        // 设置RefreshToken，时间戳为当前时间戳，直接设置即可(不用先删后设，会覆盖已有的RefreshToken)
        String currentTimeMillis = String.valueOf(System.currentTimeMillis());
        redis.set(RedisConstant.PREFIX_SHIRO_REFRESH_TOKEN + username, currentTimeMillis,
                Integer.parseInt(refreshTokenExpireTime));
        // 从Header中Authorization返回AccessToken，时间戳为当前时间戳
        String token = JwtUtil.generateJwt(username, currentTimeMillis);
        response.setHeader(ShiroConstant.AUTHORIZATION, token);
        response.setHeader(ShiroConstant.ACCESS_CONTROL_EXPOSE_HEADERS, ShiroConstant.AUTHORIZATION);
        // 更新登录时间
        umsAdminDTO.setLoginTime(LocalDateTime.now());
        LambdaUpdateWrapper<UmsAdmin> umsAdminLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        umsAdminLambdaUpdateWrapper.eq(UmsAdmin::getId, umsAdminDTO.getId());
        umsAdminLambdaUpdateWrapper.set(UmsAdmin::getLoginTime, umsAdminDTO.getLoginTime());
        umsAdminService.update(umsAdminLambdaUpdateWrapper);
        return ResponseResult.success("登录成功");


    }

    /**
     * 退出
     */
    @ApiOperation(value = "退出", httpMethod = "POST")
    @PostMapping("/logout")
    public ResponseResult<?> logout() {
        try {
            String token = "";
            // 获取头部信息
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String key = headerNames.nextElement();
                if (ShiroConstant.AUTHORIZATION.equalsIgnoreCase(key)) {
                    token = request.getHeader(key);
                }
            }
            // 效验 token
            if (StringUtils.isBlank(token)) {
                return ResponseResult.fail(ResponseCode.FAILED);
            }
            String username = JwtUtil.getClaim(token, ShiroConstant.USERNAME);
            if (StringUtils.isBlank(username)) {
                return ResponseResult.fail(ResponseCode.TOKEN_EXPIRE_OR_ERROR, ResponseCode.FAILED.getMessage());
            }
            // 清除shiro权限信息缓存
            if (redis.hasKey(RedisConstant.PREFIX_SHIRO_CACHE + username)) {
                redis.del(RedisConstant.PREFIX_SHIRO_CACHE + username);
            }
            // 清除RefreshToken
            redis.del(RedisConstant.PREFIX_SHIRO_REFRESH_TOKEN + username);
            return ResponseResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.fail(ResponseCode.FAILED, e.getMessage());
        }
    }

}
