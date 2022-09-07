package com.liboshuai.mall.tiny.module.cms.domain.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 优选专区和产品关系表
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Data
@TableName("cms_prefrence_area_product_relation")
@ApiModel(value = "CmsPrefrenceAreaProductRelation对象", description = "优选专区和产品关系表")
public class CmsPrefrenceAreaProductRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("prefrence_area_id")
    private Long prefrenceAreaId;

    @TableField("product_id")
    private Long productId;


}




