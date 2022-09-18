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
 * 专题商品关系表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("cms_subject_product_relation")
@ApiModel(value = "CmsSubjectProductRelation对象", description = "专题商品关系表")
public class CmsSubjectProductRelation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("subject_id")
    private Long subjectId;

    @TableField("product_id")
    private Long productId;


}




