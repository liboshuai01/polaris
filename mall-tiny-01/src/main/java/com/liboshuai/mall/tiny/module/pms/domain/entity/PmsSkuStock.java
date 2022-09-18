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
 * sku的库存
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("pms_sku_stock")
@ApiModel(value = "PmsSkuStock对象", description = "sku的库存")
public class PmsSkuStock extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("product_id")
    private Long productId;

    @ApiModelProperty("sku编码")
    @TableField("sku_code")
    private String skuCode;

    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty("库存")
    @TableField("stock")
    private Integer stock;

    @ApiModelProperty("预警库存")
    @TableField("low_stock")
    private Integer lowStock;

    @ApiModelProperty("销售属性1")
    @TableField("sp1")
    private String sp1;

    @TableField("sp2")
    private String sp2;

    @TableField("sp3")
    private String sp3;

    @ApiModelProperty("展示图片")
    @TableField("pic")
    private String pic;

    @ApiModelProperty("销量")
    @TableField("sale")
    private Integer sale;

    @ApiModelProperty("单品促销价格")
    @TableField("promotion_price")
    private BigDecimal promotionPrice;

    @ApiModelProperty("锁定库存")
    @TableField("lock_stock")
    private Integer lockStock;

}




