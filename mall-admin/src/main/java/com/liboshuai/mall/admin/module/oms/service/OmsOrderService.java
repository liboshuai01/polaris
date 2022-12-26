package com.liboshuai.mall.admin.module.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liboshuai.mall.admin.compone.response.ResponseResult;
import com.liboshuai.mall.admin.module.oms.domain.entity.OmsOrder;
import com.liboshuai.mall.admin.module.oms.domain.req.GenerateOrderReq;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
public interface OmsOrderService extends IService<OmsOrder> {
    /**
     * 根据提交信息生成订单
     */
    @Transactional
    ResponseResult<?> generateOrder(GenerateOrderReq generateOrderReq);

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);
}
