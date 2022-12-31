package com.liboshuai.polaris.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: liboshuai
 * @Date: 2022-12-26 15:19
 * @Description: 主启动类
 */
@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication
public class PolarisMonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(PolarisMonitorApplication.class, args);
    }
}
