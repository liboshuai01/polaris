package com.liboshuai.mall.tiny.domain.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 专题评论表
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Data
@TableName("cms_topic_comment")
@ApiModel(value = "CmsTopicComment对象", description = "专题评论表")
public class CmsTopicComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("member_nick_name")
    private String memberNickName;

    @TableField("topic_id")
    private Long topicId;

        @TableField("member_icon")
        private String memberIcon;

        @TableField("content")
        private String content;

        @TableField("create_time")
        private LocalDateTime createTime;

        @TableField("show_status")
        private Integer showStatus;


}




