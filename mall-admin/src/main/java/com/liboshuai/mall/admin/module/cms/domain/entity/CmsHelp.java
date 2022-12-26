package com.liboshuai.mall.admin.module.cms.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 帮助表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("cms_help")
@ApiModel(value = "CmsHelp对象", description = "帮助表")
public class CmsHelp extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("类别id")
    @TableField("category_id")
    private Long categoryId;

    @ApiModelProperty("图标")
    @TableField("icon")
    private String icon;

    @ApiModelProperty("标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("展示状态")
    @TableField("show_status")
    private Integer showStatus;

    @ApiModelProperty("阅读行数")
    @TableField("read_count")
    private Integer readCount;

    @ApiModelProperty("内容")
    @TableField("content")
    private String content;

}




