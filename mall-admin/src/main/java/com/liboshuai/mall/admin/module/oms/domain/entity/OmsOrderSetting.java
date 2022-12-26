package com.liboshuai.mall.admin.module.oms.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 订单设置表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("oms_order_setting")
@ApiModel(value = "OmsOrderSetting对象", description = "订单设置表")
public class OmsOrderSetting extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("秒杀订单超时关闭时间(分)")
    @TableField("flash_order_overtime")
    private Integer flashOrderOvertime;

    @ApiModelProperty("正常订单超时时间(分)")
    @TableField("normal_order_overtime")
    private Integer normalOrderOvertime;

    @ApiModelProperty("发货后自动确认收货时间（天）")
    @TableField("confirm_overtime")
    private Integer confirmOvertime;

    @ApiModelProperty("自动完成交易时间，不能申请售后（天）")
    @TableField("finish_overtime")
    private Integer finishOvertime;

    @ApiModelProperty("订单完成后自动好评时间（天）")
    @TableField("comment_overtime")
    private Integer commentOvertime;

}




