package com.liboshuai.mall.tiny.compone.config;

import com.liboshuai.mall.tiny.compone.handler.CustomizedSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: liboshuai
 * @Date: 2022-11-28 14:17
 * @Description: 自定义mybatisPlus配置类
 */

@MapperScan(basePackages = "com.liboshuai.mall.tiny")
@Configuration
public class MybatisPlusConfig {

    @Bean
    public CustomizedSqlInjector customizedSqlInjector() {
        return new CustomizedSqlInjector();
    }

}
