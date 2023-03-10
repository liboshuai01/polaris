package com.liboshuai.polaris.oms.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: liboshuai
 * @Date: 2022-12-30 15:08
 * @Description: oms-servie启动类
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class PolarislOmsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PolarislOmsServiceApplication.class, args);
    }
}
