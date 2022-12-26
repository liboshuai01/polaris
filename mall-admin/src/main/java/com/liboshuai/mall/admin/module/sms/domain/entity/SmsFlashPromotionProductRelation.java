package com.liboshuai.mall.admin.module.sms.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 * 商品限时购与商品关系表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("sms_flash_promotion_product_relation")
@ApiModel(value = "SmsFlashPromotionProductRelation对象", description = "商品限时购与商品关系表")
public class SmsFlashPromotionProductRelation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("flash_promotion_id")
    private Long flashPromotionId;

    @ApiModelProperty("编号")
    @TableField("flash_promotion_session_id")
    private Long flashPromotionSessionId;

    @TableField("product_id")
    private Long productId;

    @ApiModelProperty("限时购价格")
    @TableField("flash_promotion_price")
    private BigDecimal flashPromotionPrice;

    @ApiModelProperty("限时购数量")
    @TableField("flash_promotion_count")
    private Integer flashPromotionCount;

    @ApiModelProperty("每人限购数量")
    @TableField("flash_promotion_limit")
    private Integer flashPromotionLimit;

    @ApiModelProperty("排序")
    @TableField("sort")
    private Integer sort;

}




