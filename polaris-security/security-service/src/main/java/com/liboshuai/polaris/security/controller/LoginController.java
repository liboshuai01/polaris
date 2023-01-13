package com.liboshuai.polaris.security.controller;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONObject;
import com.liboshuai.polaris.common.constants.CommonConstant;
import com.liboshuai.polaris.common.constants.SymbolConstant;
import com.liboshuai.polaris.common.domain.Md5Util;
import com.liboshuai.polaris.common.domain.ResponseResult;
import com.liboshuai.polaris.common.utils.RandImageUtil;
import com.liboshuai.polaris.common.utils.RedisUtil;
import com.liboshuai.polaris.security.dto.SysUserDTO;
import com.liboshuai.polaris.security.entity.SysRoleIndexEntity;
import com.liboshuai.polaris.security.entity.SysUserEntity;
import com.liboshuai.polaris.security.query.LoginQuery;
import com.liboshuai.polaris.security.service.LoginService;
import com.liboshuai.polaris.security.service.SysDictService;
import com.liboshuai.polaris.security.service.SysUserService;
import com.liboshuai.polaris.security.vo.SysUserInfoVO;
import com.liboshuai.polaris.security.vo.SysUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Objects;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 00:06
 * @Description: 登录相关功能
 */
@Slf4j
@RestController
@NoArgsConstructor
@Api(tags = "登录相关功能", value = "LoginController")
public class LoginController {

    private LoginService loginService;
    private RedisUtil redisUtil;
    private SysUserService sysUserService;
    private SysDictService sysDictService;

    @Autowired
    public LoginController(LoginService loginService, RedisUtil redisUtil, SysUserService sysUserService, SysDictService sysDictService) {
        this.loginService = loginService;
        this.redisUtil = redisUtil;
        this.sysUserService = sysUserService;
        this.sysDictService = sysDictService;
    }

    private final String BASE_CHECK_CODES = "qwertyuiplkjhgfdsazxcvbnmQWERTYUPLKJHGFDSAZXCVBNM1234567890";
    private final String signatureSecret = "dd05f1c54d63749eda95f9fa6d49v442a";


    @ApiOperation(value = "登录", httpMethod = "POST")
    @PostMapping("/login")
    public ResponseResult<SysUserInfoVO> login(@Valid @RequestBody LoginQuery loginQuery) {
        log.info("-------用户{}进行登录操作-------", JSONObject.toJSONString(loginQuery));
        return loginService.login(loginQuery);
    }

    @ApiOperation(value = "获取当前登录用户信息", httpMethod = "GET")
    @GetMapping("/getUserInfo")
    public ResponseResult<?> getUserInfo(HttpServletRequest request) {
        // todo: 从token中获取用户名
        String username = "admin";
        JSONObject obj = new JSONObject();
        if (StringUtils.isNotEmpty(username)) {
            // 根据用户名查询用户信息
            ResponseResult<SysUserDTO> sysUserDTOResponseResult = sysUserService.findUserByName(username);
            if (Objects.isNull(sysUserDTOResponseResult) || !sysUserDTOResponseResult.isSuccess()) {
                return ResponseResult.fail("根据用户名查询用户信息失败");
            }
            SysUserDTO sysUserDTO = sysUserDTOResponseResult.getResult();
            SysUserVO sysUserVO = new SysUserVO();
            BeanUtils.copyProperties(sysUserDTO, sysUserVO);

            //update-begin---author:scott ---date:2022-06-20  for：vue3前端，支持自定义首页-----------
            String version = request.getHeader(CommonConstant.VERSION);
            //update-begin---author:liusq ---date:2022-06-29  for：接口返回值修改，同步修改这里的判断逻辑-----------
            SysRoleIndexEntity roleIndex = sysUserService.getDynamicIndexByUserRole(username, version);
            if (StringUtils.isNotEmpty(version) && roleIndex != null && StringUtils.isNotEmpty(roleIndex.getUrl())) {
                String homePath = roleIndex.getUrl();
                if (!homePath.startsWith(SymbolConstant.SINGLE_SLASH)) {
                    homePath = SymbolConstant.SINGLE_SLASH + homePath;
                }
                sysUserVO.setHomePath(homePath);
            }
            //update-begin---author:liusq ---date:2022-06-29  for：接口返回值修改，同步修改这里的判断逻辑-----------
            //update-end---author:scott ---date::2022-06-20  for：vue3前端，支持自定义首页--------------

            obj.put("userInfo", sysUserVO);
            obj.put("sysAllDictItems", sysDictService.queryAllDictItems());
        }
        return ResponseResult.success(obj);
    }

    /**
     * 后台生成图形验证码 ：有效
     */
    @ApiOperation("获取图形验证码")
    @GetMapping(value = "/randomImage/{_t}")
    public ResponseResult<String> randomImage(@PathVariable("_t") String key) {
        try {
            //生成验证码
            String code = RandomUtil.randomString(BASE_CHECK_CODES, 4);
            //存到redis中
            String lowerCaseCode = code.toLowerCase();

            //update-begin-author:taoyan date:2022-9-13 for: VUEN-2245 【漏洞】发现新漏洞待处理20220906
            // 加入密钥作为混淆，避免简单的拼接，被外部利用，用户自定义该密钥即可
            String origin = lowerCaseCode + key + signatureSecret;
            String realKey = Md5Util.md5Encode(origin, "utf-8");
            //update-end-author:taoyan date:2022-9-13 for: VUEN-2245 【漏洞】发现新漏洞待处理20220906

            redisUtil.set(realKey, lowerCaseCode, 60);
            log.info("获取验证码，Redis key = {}，checkCode = {}", realKey, code);
            //返回前端
            String base64 = RandImageUtil.generate(code);
            return ResponseResult.success("获取图形验证码成功",base64);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseResult.fail("获取验证码失败,请检查redis配置!");
        }
    }

}
