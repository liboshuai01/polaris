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
 * 话题表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("cms_topic")
@ApiModel(value = "CmsTopic对象", description = "话题表")
public class CmsTopic extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("category_id")
    private Long categoryId;

    @TableField("name")
    private String name;

    @TableField("start_time")
    private LocalDateTime startTime;

    @TableField("end_time")
    private LocalDateTime endTime;

    @ApiModelProperty("参与人数")
    @TableField("attend_count")
    private Integer attendCount;

    @ApiModelProperty("关注人数")
    @TableField("attention_count")
    private Integer attentionCount;

    @TableField("read_count")
    private Integer readCount;

    @ApiModelProperty("奖品名称")
    @TableField("award_name")
    private String awardName;

    @ApiModelProperty("参与方式")
    @TableField("attend_type")
    private String attendType;

    @ApiModelProperty("话题内容")
    @TableField("content")
    private String content;

}




