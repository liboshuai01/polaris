package com.liboshuai.mall.tiny.compone.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: liboshuai
 * @Date: 2022-12-26 09:05
 * @Description: 取消订单消息的发送者
 */
@Slf4j
@Component
public class CancelOrderSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(Long orderId, final long delayTimes) {
        // 给延迟队列发送信息
        amqpTemplate.convertAndSend(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getExchange(), )
    }
}
