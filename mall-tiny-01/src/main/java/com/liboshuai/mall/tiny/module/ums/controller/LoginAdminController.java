package com.liboshuai.mall.tiny.module.ums.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.liboshuai.mall.tiny.common.constants.ShiroConstant;
import com.liboshuai.mall.tiny.common.enums.ResponseCode;
import com.liboshuai.mall.tiny.common.enums.UserStatusEnum;
import com.liboshuai.mall.tiny.compone.response.ResponseResult;
import com.liboshuai.mall.tiny.module.ums.domain.dao.UmsAdmin;
import com.liboshuai.mall.tiny.module.ums.domain.dto.UmsAdminDTO;
import com.liboshuai.mall.tiny.module.ums.domain.vo.UmsAdminVo;
import com.liboshuai.mall.tiny.module.ums.service.UmsAdminService;
import com.liboshuai.mall.tiny.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UmsAdminService umsAdminService;

    private static final String AUTHORIZATION = "Authorization";

    private static final String ACCESS_CONTROL_EXPOSE_HEADERS = "Access-Control-Expose-Headers";


    /**
     * 用户注册
     */
    @ApiOperation(value = "注册", httpMethod = "POST")
    @PostMapping("/register")
    public ResponseResult<?> register(@RequestBody UmsAdminVo umsAdminVo) {
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
        umsAdminDTO.setCreateTime(LocalDateTime.now());
        umsAdminDTO.setStatus(UserStatusEnum.Enable.getCode());
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminDTO, umsAdmin);
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
        UmsAdmin user = umsAdminService.findByUserName(username);
        if (Objects.isNull(user)) {
            return ResponseResult.fail(ResponseCode.INCORRECT_CREDENTIALS);
        }
        String enPassword = new SimpleHash(ShiroConstant.ALGORITH_NAME, password,
                user.getSalt(), user.getSaltCount()).toString();
        if (!Objects.equals(user.getPassword(), enPassword)) {
            return ResponseResult.fail(ResponseCode.INCORRECT_CREDENTIALS);
        }
        // 从Header中Authorization返回AccessToken，时间戳为当前时间戳
        String currentTimeMills = String.valueOf(System.currentTimeMillis());
        String token = JwtUtil.sign(username, currentTimeMills);
        response.setHeader(AUTHORIZATION, token);
        response.setHeader(ACCESS_CONTROL_EXPOSE_HEADERS, AUTHORIZATION);
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
                String value = request.getHeader(key);
                if (AUTHORIZATION.equalsIgnoreCase(key)) {
                    token = value;
                }
            }
            // 效验 token
            if (StringUtils.isBlank(token)) {
                return ResponseResult.fail(ResponseCode.FAILED);
            }
            String account = JwtUtil.getClaim(token, ShiroConstant.ACCOUNT);
            if (StringUtils.isBlank(account)) {
                return ResponseResult.fail(ResponseCode.TOKEN_EXPIRE_OR_ERROR, ResponseCode.FAILED.getMessage());
            }
            return ResponseResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.fail(ResponseCode.FAILED, e.getMessage());
        }
    }
}
