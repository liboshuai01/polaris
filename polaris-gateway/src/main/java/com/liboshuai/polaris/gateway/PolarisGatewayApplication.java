package com.liboshuai.polaris.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/1 02:29
 * @Description: polaris-gateway 主启动类
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PolarisGatewayApplication {
    public static void main(String[] args) {
        // 让sentinel识别为网关服务
        System.setProperty("csp.sentinel.app.type", "1");
        SpringApplication.run(PolarisGatewayApplication.class, args);
    }
}
