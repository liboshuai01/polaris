package com.liboshuai.mall.admin.module.cms.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 * 专题评论表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("cms_subject_comment")
@ApiModel(value = "CmsSubjectComment对象", description = "专题评论表")
public class CmsSubjectComment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("subject_id")
    private Long subjectId;

    @TableField("member_nick_name")
    private String memberNickName;

    @TableField("member_icon")
    private String memberIcon;

    @TableField("content")
    private String content;

    @TableField("show_status")
    private Integer showStatus;


}




