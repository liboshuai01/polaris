package com.liboshuai.mall.admin.module.pms.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 * 产品满减表(只针对同商品)
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("pms_product_full_reduction")
@ApiModel(value = "PmsProductFullReduction对象", description = "产品满减表(只针对同商品)")
public class PmsProductFullReduction extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("product_id")
    private Long productId;

    @TableField("full_price")
    private BigDecimal fullPrice;

    @TableField("reduce_price")
    private BigDecimal reducePrice;

}




