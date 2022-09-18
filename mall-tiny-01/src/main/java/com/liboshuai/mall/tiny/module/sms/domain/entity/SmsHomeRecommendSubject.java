package com.liboshuai.mall.tiny.module.sms.domain.entity;

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
 * 首页推荐专题表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("sms_home_recommend_subject")
@ApiModel(value = "SmsHomeRecommendSubject对象", description = "首页推荐专题表")
public class SmsHomeRecommendSubject extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("subject_id")
    private Long subjectId;

    @TableField("subject_name")
    private String subjectName;

    @TableField("recommend_status")
    private Integer recommendStatus;

    @TableField("sort")
    private Integer sort;

}




