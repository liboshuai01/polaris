package com.liboshuai.mall.admin.common.constants;

/**
 * @Author: liboshuai
 * @Date: 2022-09-09 12:37
 * @Description: Jwt常量
 */
public interface ShiroConstant {

    /**
     * Jwt-account
     */
    String USERNAME = "username";

    /**
     * 散列算法名称
     */
    String ALGORITH_NAME = "MD5";


    /**
     * 散列迭代次数
     */
    int HASH_INTERATIONS = 2;

    /**
     * 存储token的请求头
     */
    String AUTHORIZATION = "Authorization";

    /**
     * 存储Authorization的请求头
     */
    String ACCESS_CONTROL_EXPOSE_HEADERS = "Access-Control-Expose-Headers";

    /**
     * JWT-currentTimeMillis:
     */
    String CURRENT_TIME_MILLIS = "currentTimeMillis";

    String CONTENT_TYPE = "application/json; charset=utf-8";

    String TOKEN_CANNOT_BE_EMPTY = "token cannot be empty";
    String TOKEN_INVALID = "token invalid";
    String USER_DIDNT_EXISTED = "user didn't existed";
    String REALM_NAME = "userRealm";
    String TOKEN_EXPIRED_OR_INCORRECT = "token expired or incorrect.";
}
