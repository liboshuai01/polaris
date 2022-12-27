package com.liboshuai.mall.admin.module.cms.domain.dao;

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
    * 帮助分类表
    * </p>
*
* @author liboshuai
* @since 2022-12-27
*/
    @Data
    @TableName("cms_help_category")
    @ApiModel(value = "CmsHelpCategory对象", description = "帮助分类表")
    public class CmsHelpCategory implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        @TableField("name")
    private String name;

            @ApiModelProperty("分类图标")
        @TableField("icon")
    private String icon;

            @ApiModelProperty("专题数量")
        @TableField("help_count")
    private Integer helpCount;

        @TableField("show_status")
    private Integer showStatus;

        @TableField("sort")
    private Integer sort;

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

            @ApiModelProperty("逻辑删除: 0-未删除, 1-已删除")
        @TableField("is_delete")
    private String isDelete;


}




