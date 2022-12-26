package com.liboshuai.mall.tiny.compone.mq;

import com.liboshuai.mall.tiny.module.oms.service.OmsOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: liboshuai
 * @Date: 2022-12-26 10:06
 * @Description: 取消订单消息的处理者
 */
@Slf4j
@Component
@RabbitListener(queues = "mall.order.cancel")
public class CancelOrderReceiver {
    @Autowired
    private OmsOrderService omsOrderService;

    @RabbitHandler
    public void handle(Long orderId) {
        log.info("receive delay message orderId:{}",orderId);
        omsOrderService.cancelOrder(orderId);
    }
}
