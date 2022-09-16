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
 * 产品评价回复表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("pms_comment_replay")
@ApiModel(value = "PmsCommentReplay对象", description = "产品评价回复表")
public class PmsCommentReplay extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("comment_id")
    private Long commentId;

    @TableField("member_nick_name")
    private String memberNickName;

    @TableField("member_icon")
    private String memberIcon;

    @TableField("content")
    private String content;

    @ApiModelProperty("评论人员类型；0->会员；1->管理员")
    @TableField("type")
    private Integer type;
}




