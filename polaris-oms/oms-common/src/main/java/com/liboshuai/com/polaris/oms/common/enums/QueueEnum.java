package com.liboshuai.com.polaris.oms.common.enums;

import lombok.Getter;

/**
 * @Author: liboshuai
 * @Date: 2022-12-26 09:36
 * @Description: 消息队列枚举配置
 */
@Getter
public enum QueueEnum {
    /**
     * 消息通知队列
     */
    QUEUE_ORDER_CANCEL("polaris.order.direct", "polaris.order.cancel", "polaris.order.cancel"),
    /**
     * 消息通知ttl队列
     */
    QUEUE_TTL_ORDER_CANCEL("polaris.order.direct.ttl", "polaris.order.cancel.ttl", "polaris.order.cancel.ttl");

    /**
     * 交换名称
     */
    private String exchange;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 路由键
     */
    private String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }
}
