package com.liboshuai.mall.tiny.module.ums.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.tiny.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    @ApiModelProperty("创建用户")
    @TableField("create_user")
    private String createUser;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新用户")
    @TableField("update_user")
    private String updateUser;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("是否被逻辑删除 0-未被删除 1-已被删除")
    @TableField("is_delete")
    private String isDelete;


}



