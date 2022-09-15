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
    * 帮助表
    * </p>
*
* @author liboshuai
* @since 2022-09-16
*/
    @Data
    @TableName("cms_help")
    @ApiModel(value = "CmsHelp对象", description = "帮助表")
    public class CmsHelp implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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




