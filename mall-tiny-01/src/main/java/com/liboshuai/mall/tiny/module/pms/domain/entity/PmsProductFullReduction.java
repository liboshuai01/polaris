package com.liboshuai.mall.tiny.module.pms.domain.entity;

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




