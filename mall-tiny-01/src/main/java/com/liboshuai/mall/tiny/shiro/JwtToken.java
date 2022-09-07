package com.liboshuai.mall.tiny.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Author: liboshuai
 * @Date: 2022-09-08 00:53
 * @Description: JwtToken 类
 */
public class JwtToken implements AuthenticationToken {
    private static final long serialVersionUID = -8523592214400915953L;

    private final String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
