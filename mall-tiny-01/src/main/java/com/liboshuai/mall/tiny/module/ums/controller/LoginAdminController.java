package com.liboshuai.mall.tiny.module.ums.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.liboshuai.mall.tiny.common.constants.JwtConstant;
import com.liboshuai.mall.tiny.common.enums.ResponseCode;
import com.liboshuai.mall.tiny.compone.response.ResponseResult;
import com.liboshuai.mall.tiny.module.ums.domain.dao.UmsAdmin;
import com.liboshuai.mall.tiny.module.ums.service.UmsAdminService;
import com.liboshuai.mall.tiny.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Objects;

/**
 * @Author: liboshuai
 * @Date: 2022-09-10 01:27
 * @Description: 用户登录controller
 */
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
     * 用户登录
     */
    @PostMapping("/login")
    public ResponseResult<?> login(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return ResponseResult.fail(ResponseCode.USERNAME_PASSWORD_NULL);
        }
        UmsAdmin user = umsAdminService.findByUserName(username);
        if (Objects.isNull(user)) {
            return ResponseResult.fail(ResponseCode.INCORRECT_CREDENTIALS);
        }
        if (!Objects.equals(user.getPassword(), password)) {
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
    @RequestMapping("/logout")
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
            String account = JwtUtil.getClaim(token, JwtConstant.ACCOUNT);
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
