package com.liboshuai.polaris.sms.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther: Bernardo
 * @Date: 2022/12/31 17:20
 * @Description:
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class PolarisSmsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PolarisSmsServiceApplication.class, args);
    }
}
