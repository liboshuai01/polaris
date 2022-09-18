package com.liboshuai.mall.tiny.utils;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: liboshuai
 * @Date: 2022-09-19 04:36
 * @Description: 脱敏工具类
 */
@Component
public class EncryptorUtil {
    @Autowired
    private StringEncryptor stringEncryptor;

    public String encrypt(String originalText) {
        return stringEncryptor.encrypt(originalText);
    }
}
