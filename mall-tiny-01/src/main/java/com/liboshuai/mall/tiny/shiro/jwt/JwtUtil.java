package com.liboshuai.mall.tiny.shiro.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.liboshuai.mall.tiny.common.constants.ShiroConstant;
import com.liboshuai.mall.tiny.utils.Base64Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @Author: liboshuai
 * @Date: 2022-09-09 12:10
 * @Description: Jwt工具类
 */
@Slf4j
@Component
public class JwtUtil {

    @Value("${config.encrypt-jwtKey}")
    private String ENCRYPT_JWT_KEY;

    @Value("${config.accessToken-expireTime}")
    private String ACCESS_TOKEN_EXPIRE_TIME;

    private static String ENCRYPT_JWT_KEY_STATIC;
    private static String ACCESS_TOKEN_EXPIRE_TIME_STATIC;

    @PostConstruct
    private void init() {
        ENCRYPT_JWT_KEY_STATIC = ENCRYPT_JWT_KEY;
        ACCESS_TOKEN_EXPIRE_TIME_STATIC = ACCESS_TOKEN_EXPIRE_TIME;
    }


    /**
     * 效验token是否正确
     */
    public static boolean verify(String token) {
        try {
            String secret = Base64Util.decode(ENCRYPT_JWT_KEY_STATIC);
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
     * 获取Jwt payload的内容
     */
    public static String getClaim(String token, String claim) {
        try {
            // 只能输出String类型，如果是其他类型则返回null
            return JWT.decode(token).getClaim(claim).asString();
        } catch (JWTDecodeException e) {
            log.error("解密token中的公共信息异常：{}" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成Jwt
     */
    public static String generateJwt(String username, String currentTimeMillis) {
        try {
            // 获取jwt过期时间（单位为毫秒）
            Date expireDate = new Date(System.currentTimeMillis() + Long.parseLong(ACCESS_TOKEN_EXPIRE_TIME_STATIC) * 1000);
            // 获取签名
            String secret = Base64Util.decode(ENCRYPT_JWT_KEY_STATIC);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 生成Jwt
            return JWT.create()
                    // 存放username
                    .withClaim(ShiroConstant.USERNAME, username)
                    // 存放当前时间戳
                    .withClaim(ShiroConstant.CURRENT_TIME_MILLIS, currentTimeMillis)
                    .withExpiresAt(expireDate)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            log.error("token生成失败异常：{}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
