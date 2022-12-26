package com.liboshuai.mall.admin.module.pms.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 产品属性分类表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("pms_product_attribute_category")
@ApiModel(value = "PmsProductAttributeCategory对象", description = "产品属性分类表")
public class PmsProductAttributeCategory extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("name")
    private String name;

    @ApiModelProperty("属性数量")
    @TableField("attribute_count")
    private Integer attributeCount;

    @ApiModelProperty("参数数量")
    @TableField("param_count")
    private Integer paramCount;

}




