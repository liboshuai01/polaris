package com.liboshuai.mall.oms.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: liboshuai
 * @Date: 2022-12-30 15:08
 * @Description: oms-servie启动类
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MallOmsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallOmsServiceApplication.class, args);
    }
}
