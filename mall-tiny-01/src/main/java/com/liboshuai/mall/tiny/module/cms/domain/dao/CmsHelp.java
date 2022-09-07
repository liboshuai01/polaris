package com.liboshuai.mall.tiny.module.cms.domain.dao;

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
 * 帮助表
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Data
@TableName("cms_help")
@ApiModel(value = "CmsHelp对象", description = "帮助表")
public class CmsHelp implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("category_id")
    private Long categoryId;

    @TableField("icon")
    private String icon;

        @TableField("title")
        private String title;

        @TableField("show_status")
        private Integer showStatus;

        @TableField("create_time")
        private LocalDateTime createTime;

        @TableField("read_count")
        private Integer readCount;

        @TableField("content")
        private String content;


}




