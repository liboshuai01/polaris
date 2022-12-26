package com.liboshuai.mall.admin.module.ums.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 * 会员积分成长规则表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("ums_member_rule_setting")
@ApiModel(value = "UmsMemberRuleSetting对象", description = "会员积分成长规则表")
public class UmsMemberRuleSetting extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("连续签到天数")
    @TableField("continue_sign_day")
    private Integer continueSignDay;

    @ApiModelProperty("连续签到赠送数量")
    @TableField("continue_sign_point")
    private Integer continueSignPoint;

    @ApiModelProperty("每消费多少元获取1个点")
    @TableField("consume_per_point")
    private BigDecimal consumePerPoint;

    @ApiModelProperty("最低获取点数的订单金额")
    @TableField("low_order_amount")
    private BigDecimal lowOrderAmount;

    @ApiModelProperty("每笔订单最高获取点数")
    @TableField("max_point_per_order")
    private Integer maxPointPerOrder;

    @ApiModelProperty("类型：0->积分规则；1->成长值规则")
    @TableField("type")
    private Integer type;

}




