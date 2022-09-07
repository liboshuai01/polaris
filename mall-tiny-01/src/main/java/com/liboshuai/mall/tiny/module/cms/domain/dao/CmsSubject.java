package com.liboshuai.mall.tiny.module.cms.domain.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 专题表
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Data
@TableName("cms_subject")
@ApiModel(value = "CmsSubject对象", description = "专题表")
public class CmsSubject implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("category_id")
    private Long categoryId;

    @TableField("title")
    private String title;

    @ApiModelProperty("专题主图")
    @TableField("pic")
    private String pic;

    @ApiModelProperty("关联产品数量")
    @TableField("product_count")
    private Integer productCount;

    @TableField("recommend_status")
    private Integer recommendStatus;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("collect_count")
    private Integer collectCount;

    @TableField("read_count")
    private Integer readCount;

    @TableField("comment_count")
    private Integer commentCount;

    @ApiModelProperty("画册图片用逗号分割")
    @TableField("album_pics")
    private String albumPics;

    @TableField("description")
    private String description;

    @ApiModelProperty("显示状态：0->不显示；1->显示")
    @TableField("show_status")
    private Integer showStatus;

    @TableField("content")
    private String content;

    @ApiModelProperty("转发数")
    @TableField("forward_count")
    private Integer forwardCount;

    @ApiModelProperty("专题分类名称")
    @TableField("category_name")
    private String categoryName;


}




