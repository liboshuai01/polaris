package com.liboshuai.polaris.common.constants;

/**
 * @Author: liboshuai
 * @Date: 2023-01-17 18:55
 * @Description: 服务名称
 */
public interface ServiceNameConstants {

    /**
     * 微服务名：系统管理模块
     */
    String SERVICE_SYSTEM = "jeecg-system";
    /**
     * 微服务名： demo模块
     */
    String SERVICE_DEMO = "jeecg-demo";

    /**
     * gateway通过header传递根路径 basePath
     */
    String X_GATEWAY_BASE_PATH = "X_GATEWAY_BASE_PATH";

}
