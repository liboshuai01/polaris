package com.liboshuai.mall.admin.module.ums.domain.dao;

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
    * 后台菜单表
    * </p>
*
* @author liboshuai
* @since 2022-12-27
*/
    @Data
    @TableName("ums_menu")
    @ApiModel(value = "UmsMenu对象", description = "后台菜单表")
    public class UmsMenu implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

            @ApiModelProperty("父级ID")
        @TableField("parent_id")
    private Long parentId;

            @ApiModelProperty("创建时间")
        @TableField("create_time")
    private LocalDateTime createTime;

            @ApiModelProperty("菜单名称")
        @TableField("title")
    private String title;

            @ApiModelProperty("菜单级数")
        @TableField("level")
    private Integer level;

            @ApiModelProperty("菜单排序")
        @TableField("sort")
    private Integer sort;

            @ApiModelProperty("前端名称")
        @TableField("name")
    private String name;

            @ApiModelProperty("前端图标")
        @TableField("icon")
    private String icon;

            @ApiModelProperty("前端隐藏")
        @TableField("hidden")
    private Integer hidden;

            @ApiModelProperty("创建用户")
        @TableField("create_user")
    private String createUser;

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




