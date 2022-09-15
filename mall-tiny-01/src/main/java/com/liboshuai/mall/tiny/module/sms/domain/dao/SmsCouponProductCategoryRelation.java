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
 * 优惠券和产品分类关系表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("sms_coupon_product_category_relation")
@ApiModel(value = "SmsCouponProductCategoryRelation对象", description = "优惠券和产品分类关系表")
public class SmsCouponProductCategoryRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("coupon_id")
    private Long couponId;

    @TableField("product_category_id")
    private Long productCategoryId;

    @ApiModelProperty("产品分类名称")
    @TableField("product_category_name")
    private String productCategoryName;

    @ApiModelProperty("父分类名称")
    @TableField("parent_category_name")
    private String parentCategoryName;


}




