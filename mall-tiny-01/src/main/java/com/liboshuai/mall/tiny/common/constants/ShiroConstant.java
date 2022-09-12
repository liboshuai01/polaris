package com.liboshuai.mall.tiny.common.constants;

/**
 * @Author: liboshuai
 * @Date: 2022-09-09 12:37
 * @Description: Jwt常量
 */
public interface ShiroConstant {

    /**
     * Jwt-account
     */
    String ACCOUNT = "account";

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
}
