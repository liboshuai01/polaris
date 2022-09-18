package com.liboshuai.mall.tiny.module.ums.domain.entity;

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
 * 会员与产品分类关系表（用户喜欢的分类）
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("ums_member_product_category_relation")
@ApiModel(value = "UmsMemberProductCategoryRelation对象", description = "会员与产品分类关系表（用户喜欢的分类）")
public class UmsMemberProductCategoryRelation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("member_id")
    private Long memberId;

    @TableField("product_category_id")
    private Long productCategoryId;

}




