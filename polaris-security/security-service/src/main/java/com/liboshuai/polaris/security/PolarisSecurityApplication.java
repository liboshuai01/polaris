package com.liboshuai.polaris.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/1 23:56
 * @Description: polaris登录授权模块主启动类
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.liboshuai.polaris"})
public class PolarisSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(PolarisSecurityApplication.class, args);
    }
}
