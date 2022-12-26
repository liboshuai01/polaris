package com.liboshuai.mall.tiny.module.oms.domain.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: liboshuai
 * @Date: 2022-12-26 10:11
 * @Description: 生成订单请求入参
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenerateOrderReq {
    /**
     * 收货地址id
     */
    @ApiModelProperty("收货地址id")
    private Long memberReceiveAddressId;

    /**
     * 优惠券id
     */
    @ApiModelProperty("优惠券id")
    private Long couponId;

    /**
     * 使用的积分数
     */
    @ApiModelProperty("使用的积分数")
    private Integer userIntegration;

    /**
     * 支付方式
     */
    @ApiModelProperty("支付方式")
    private Integer payType;
}

