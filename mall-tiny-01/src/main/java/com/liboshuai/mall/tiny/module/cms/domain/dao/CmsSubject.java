package com.liboshuai.mall.tiny.module.cms.domain.dao;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableField;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.baomidou.mybatisplus.annotation.TableName;
    import java.io.Serializable;
    import java.time.LocalDateTime;
    import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
    import lombok.Data;

/**
* <p>
    * 专题表
    * </p>
*
* @author liboshuai
* @since 2022-09-16
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

            @ApiModelProperty("创建用户")
        @TableField("create_user")
    private String createUser;

            @ApiModelProperty("创建时间")
        @TableField("create_time")
    private LocalDateTime createTime;

            @ApiModelProperty("更新用户")
        @TableField("update_user")
    private String updateUser;

            @ApiModelProperty("更新时间")
        @TableField("update_time")
    private LocalDateTime updateTime;

            @ApiModelProperty("是否被逻辑删除 0-未被删除 1-已被删除")
        @TableField("is_delete")
    private String isDelete;


}




