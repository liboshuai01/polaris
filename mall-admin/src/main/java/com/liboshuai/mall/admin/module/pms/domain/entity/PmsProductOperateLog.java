package com.liboshuai.mall.admin.module.pms.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("pms_product_operate_log")
@ApiModel(value = "PmsProductOperateLog对象", description = "")
public class PmsProductOperateLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("product_id")
    private Long productId;

    @TableField("price_old")
    private BigDecimal priceOld;

    @TableField("price_new")
    private BigDecimal priceNew;

    @TableField("sale_price_old")
    private BigDecimal salePriceOld;

    @TableField("sale_price_new")
    private BigDecimal salePriceNew;

    @ApiModelProperty("赠送的积分")
    @TableField("gift_point_old")
    private Integer giftPointOld;

    @TableField("gift_point_new")
    private Integer giftPointNew;

    @TableField("use_point_limit_old")
    private Integer usePointLimitOld;

    @TableField("use_point_limit_new")
    private Integer usePointLimitNew;

    @ApiModelProperty("操作人")
    @TableField("operate_man")
    private String operateMan;

}




