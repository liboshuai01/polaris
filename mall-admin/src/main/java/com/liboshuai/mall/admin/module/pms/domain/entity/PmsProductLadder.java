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
 * 产品阶梯价格表(只针对同商品)
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("pms_product_ladder")
@ApiModel(value = "PmsProductLadder对象", description = "产品阶梯价格表(只针对同商品)")
public class PmsProductLadder extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("product_id")
    private Long productId;

    @ApiModelProperty("满足的商品数量")
    @TableField("count")
    private Integer count;

    @ApiModelProperty("折扣")
    @TableField("discount")
    private BigDecimal discount;

    @ApiModelProperty("折后价格")
    @TableField("price")
    private BigDecimal price;

}




