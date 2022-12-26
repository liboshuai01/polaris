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
 * 商品会员价格表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("pms_member_price")
@ApiModel(value = "PmsMemberPrice对象", description = "商品会员价格表")
public class PmsMemberPrice extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("product_id")
    private Long productId;

    @TableField("member_level_id")
    private Long memberLevelId;

    @ApiModelProperty("会员价格")
    @TableField("member_price")
    private BigDecimal memberPrice;

    @TableField("member_level_name")
    private String memberLevelName;

}




