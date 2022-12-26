package com.liboshuai.mall.admin.module.ums.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 * 用户和标签关系表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("ums_member_member_tag_relation")
@ApiModel(value = "UmsMemberMemberTagRelation对象", description = "用户和标签关系表")
public class UmsMemberMemberTagRelation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("member_id")
    private Long memberId;

    @TableField("tag_id")
    private Long tagId;

}




