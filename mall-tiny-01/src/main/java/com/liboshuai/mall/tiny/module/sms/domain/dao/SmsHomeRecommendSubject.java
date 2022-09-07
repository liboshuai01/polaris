package com.liboshuai.mall.tiny.module.sms.domain.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 首页推荐专题表
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Data
@TableName("sms_home_recommend_subject")
@ApiModel(value = "SmsHomeRecommendSubject对象", description = "首页推荐专题表")
public class SmsHomeRecommendSubject implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("subject_id")
    private Long subjectId;

    @TableField("subject_name")
    private String subjectName;

        @TableField("recommend_status")
        private Integer recommendStatus;

        @TableField("sort")
        private Integer sort;


}




