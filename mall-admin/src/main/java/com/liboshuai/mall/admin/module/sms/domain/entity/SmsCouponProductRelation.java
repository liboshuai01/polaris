package com.liboshuai.mall.admin.module.sms.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 优惠券和产品的关系表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("sms_coupon_product_relation")
@ApiModel(value = "SmsCouponProductRelation对象", description = "优惠券和产品的关系表")
public class SmsCouponProductRelation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("coupon_id")
    private Long couponId;

    @TableField("product_id")
    private Long productId;

    @ApiModelProperty("商品名称")
    @TableField("product_name")
    private String productName;

    @ApiModelProperty("商品编码")
    @TableField("product_sn")
    private String productSn;

}




