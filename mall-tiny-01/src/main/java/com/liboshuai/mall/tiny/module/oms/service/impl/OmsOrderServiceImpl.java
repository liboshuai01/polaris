package com.liboshuai.mall.tiny.module.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.mall.tiny.compone.mq.CancelOrderSender;
import com.liboshuai.mall.tiny.compone.response.ResponseResult;
import com.liboshuai.mall.tiny.module.oms.domain.entity.OmsOrder;
import com.liboshuai.mall.tiny.module.oms.domain.req.GenerateOrderReq;
import com.liboshuai.mall.tiny.module.oms.mapper.OmsOrderMapper;
import com.liboshuai.mall.tiny.module.oms.service.OmsOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Slf4j
@Service
public class OmsOrderServiceImpl extends ServiceImpl<OmsOrderMapper, OmsOrder> implements OmsOrderService {

    @Autowired
    private CancelOrderSender cancelOrderSender;

    /**
     * 根据提交信息生成订单
     */
    @Override
    public ResponseResult<?> generateOrder(GenerateOrderReq generateOrderReq) {
        // todo: 业务逻辑待编写
        log.info("process generateOrder");
        //下单完成后开启一个延迟消息，用于当用户没有付款时取消订单（orderId应该在下单后生成）
        sendDelayMessageCancelOrder(11L);
        return ResponseResult.success("下单成功");
    }

    /**
     * 取消单个超时订单
     */
    @Override
    public void cancelOrder(Long orderId) {
        // todo: 业务逻辑待编写
        log.info("process cancelOrder orderId:{}",orderId);
    }

    private void sendDelayMessageCancelOrder(Long orderId) {
        //获取订单超时时间，假设为60分钟(测试用的30秒)
        long delayTimes = 30 * 1000;
        // 发送延迟消息
        cancelOrderSender.sendMessage(orderId, delayTimes);
    }
}
