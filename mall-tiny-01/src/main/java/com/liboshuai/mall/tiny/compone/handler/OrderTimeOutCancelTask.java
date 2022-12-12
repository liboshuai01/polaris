package com.liboshuai.mall.tiny.compone.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: liboshuai
 * @Date: 2022-10-09 07:07
 * @Description: 订单超出取消并解锁库存定时器
 */
@Slf4j
@Component
public class OrderTimeOutCancelTask {
    /**
     * 每10分钟扫描一次，扫描设定超时时间之前下的订单，如果没支付则取消该订单
     */
//    @Scheduled(cron = "0 0/10 * ? * ?")
//    private void cancelTimeOutOrder() {
//        // TODO: 业务代码待实现
//        log.info("取消订单，并根据sku编号释放锁定库存");
//    }
}
