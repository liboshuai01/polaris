package com.liboshuai.mall.admin.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @Author: liboshuai
 * @Date: 2022-09-09 00:04
 * @Description:
 */
public class Base64Util {

    /**
     * 加密JDK1.8
     */
    public static String encode(String str) {
        byte[] encodeBytes = Base64.getEncoder().encode(str.getBytes(StandardCharsets.UTF_8));
        return new String(encodeBytes);
    }

    /**
     * 加密JDK1.8（根据Byte数组）
     */
    public static String encode(byte[] str) {
        byte[] encodeBytes = Base64.getEncoder().encode(str);
        return new String(encodeBytes);
    }

    /**
     * 解密JDK1.8
     */
    public static String decode(String str) {
        byte[] decodeBytes = Base64.getDecoder().decode(str.getBytes(StandardCharsets.UTF_8));
        return new String(decodeBytes);
    }

}
