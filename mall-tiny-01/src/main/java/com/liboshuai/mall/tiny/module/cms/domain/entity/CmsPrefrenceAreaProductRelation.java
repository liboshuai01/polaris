package com.liboshuai.mall.tiny.module.cms.domain.entity;

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
 * 优选专区和产品关系表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("cms_prefrence_area_product_relation")
@ApiModel(value = "CmsPrefrenceAreaProductRelation对象", description = "优选专区和产品关系表")
public class CmsPrefrenceAreaProductRelation extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @TableField("prefrence_area_id")
    private Long prefrenceAreaId;

    @TableField("product_id")
    private Long productId;


}




