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
import java.time.LocalDateTime;

/**
 * <p>
 * 产品分类
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("pms_product_category")
@ApiModel(value = "PmsProductCategory对象", description = "产品分类")
public class PmsProductCategory extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("上机分类的编号：0表示一级分类")
    @TableField("parent_id")
    private Long parentId;

    @TableField("name")
    private String name;

    @ApiModelProperty("分类级别：0->1级；1->2级")
    @TableField("level")
    private Integer level;

    @TableField("product_count")
    private Integer productCount;

    @TableField("product_unit")
    private String productUnit;

    @ApiModelProperty("是否显示在导航栏：0->不显示；1->显示")
    @TableField("nav_status")
    private Integer navStatus;

    @ApiModelProperty("显示状态：0->不显示；1->显示")
    @TableField("show_status")
    private Integer showStatus;

    @TableField("sort")
    private Integer sort;

    @ApiModelProperty("图标")
    @TableField("icon")
    private String icon;

    @TableField("keywords")
    private String keywords;

    @ApiModelProperty("描述")
    @TableField("description")
    private String description;

}




