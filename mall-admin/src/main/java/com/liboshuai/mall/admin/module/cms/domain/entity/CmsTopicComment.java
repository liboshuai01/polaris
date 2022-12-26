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
@TableName("cms_topic_comment")
@ApiModel(value = "CmsTopicComment对象", description = "专题评论表")
public class CmsTopicComment extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @TableField("member_nick_name")
    private String memberNickName;

    @TableField("topic_id")
    private Long topicId;

    @TableField("member_icon")
    private String memberIcon;

    @TableField("content")
    private String content;

    @TableField("show_status")
    private Integer showStatus;


}




