package com.liboshuai.mall.tiny.module.ums.service.impl;

import com.liboshuai.mall.tiny.MallTiny01Application;
import com.liboshuai.mall.tiny.utils.JasyptUtils;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Author: liboshuai
 * @Date: 2022-09-19 05:52
 * @Description:
 */
@Slf4j
public class EncryptorTest {
    @Test
    public void testEncrypt(){
        String plainText = "#GUFCeC0GN%O";
        String ciperText = JasyptUtils.encrypt(plainText);
        log.info("加密后的密文为：{}", ciperText);
    }

    @Test
    public void testDecrypt(){
        String ciperText = "KZeGx0ixuy4UrBp1HuhiDNnKB0cJr0cW";
        String plainText = JasyptUtils.decrypt(ciperText);
        log.info("解密后的明文为：{}", plainText);
    }
}
