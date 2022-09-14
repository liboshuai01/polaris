package com.liboshuai.mall.tiny.utils;

import com.liboshuai.mall.tiny.common.constants.ShiroConstant;
import com.liboshuai.mall.tiny.shiro.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: liboshuai
 * @Date: 2022-09-15 01:39
 * @Description: shiro工具类
 */
@Component
public class ShiroUtil {

    @Autowired
    private HttpServletRequest request;

    /**
     * 获取当前登录用户
     */
    public String getCurrentUser() {
        String token = request.getHeader(ShiroConstant.AUTHORIZATION);
        return JwtUtil.getClaim(token, ShiroConstant.USERNAME);
    }
}
