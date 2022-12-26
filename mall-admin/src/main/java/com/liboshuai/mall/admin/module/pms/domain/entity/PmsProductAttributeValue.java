package com.liboshuai.mall.admin.module.pms.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 存储产品参数信息的表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("pms_product_attribute_value")
@ApiModel(value = "PmsProductAttributeValue对象", description = "存储产品参数信息的表")
public class PmsProductAttributeValue extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("product_id")
    private Long productId;

    @TableField("product_attribute_id")
    private Long productAttributeId;

    @ApiModelProperty("手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开")
    @TableField("value")
    private String value;

}




