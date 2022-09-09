package com.liboshuai.mall.tiny.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @Author: liboshuai
 * @Date: 2022-09-09 12:10
 * @Description: Jwt工具类
 */
@Slf4j
public class JwtUtil {

    /**
     * token过期时间
     */
    private static final String ACCESS_TOKEN_EXPIRE_TIME = "600";

    /**
     * jwt认证加密私钥
     */
    private static final String ENCRYPT_JWT_KEY = "U0JBUElOENhspJrzkyNjQ1NA" ;

    private static final String claim = "account";

    /**
     * 效验token是否正确
     */
    public static boolean verify(String token) {
        try {
            String secret = getClaim(token, claim) + Base64Util.decode(ENCRYPT_JWT_KEY);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            jwtVerifier.verify(token);
            return true;
        } catch (UnsupportedEncodingException e) {
            log.error("token认证失败异常：{}", e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 解密token信息
     */
    public static String getClaim(String token, String claim) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            // 只能输出String类型，如果是其他类型则返回null
            return jwt.getClaim(claim).asString();
        } catch (JWTDecodeException e) {
            log.error("解密token中的公共信息异常：{}" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生产签名
     */
    public static String sign(String account, String currentTimeMillis) {
        try {
            String secret =  account + Base64Util.decode(ENCRYPT_JWT_KEY);
            // 单位为毫秒
            Date expireDate = new Date(System.currentTimeMillis() + Long.parseLong(ACCESS_TOKEN_EXPIRE_TIME) * 1000);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带account账号信息
            return JWT.create()
                    .withClaim("account", account)
                    .withClaim("currentTimeMillis", currentTimeMillis)
                    .withExpiresAt(expireDate)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            log.error("token生成失败异常：{}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
