package com.liboshuai.mall.tiny.module.sms.domain.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 优惠券和产品的关系表
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Data
@TableName("sms_coupon_product_relation")
@ApiModel(value = "SmsCouponProductRelation对象", description = "优惠券和产品的关系表")
public class SmsCouponProductRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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




