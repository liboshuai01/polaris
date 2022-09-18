package com.liboshuai.mall.tiny.module.ums.service.impl;

import com.liboshuai.mall.tiny.MallTiny01Application;
import org.jasypt.encryption.StringEncryptor;
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
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MallTiny01Application.class)
public class EncryptorTest {

    @Autowired
    private StringEncryptor stringEncryptor;

    /**
     * 使用前添加配置文件jasypt.encryptor.password=jar包命令中
     */
    @Test
    public void test() {
        String encrypt = stringEncryptor.encrypt("root");
        System.out.println("脱敏数据: \n" + encrypt);
    }
}
