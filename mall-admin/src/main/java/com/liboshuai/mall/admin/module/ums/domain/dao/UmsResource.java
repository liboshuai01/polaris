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
    * 后台资源表
    * </p>
*
* @author liboshuai
* @since 2022-12-27
*/
    @Data
    @TableName("ums_resource")
    @ApiModel(value = "UmsResource对象", description = "后台资源表")
    public class UmsResource implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

            @ApiModelProperty("创建时间")
        @TableField("create_time")
    private LocalDateTime createTime;

            @ApiModelProperty("资源名称")
        @TableField("name")
    private String name;

            @ApiModelProperty("资源URL")
        @TableField("url")
    private String url;

            @ApiModelProperty("描述")
        @TableField("description")
    private String description;

            @ApiModelProperty("资源分类ID")
        @TableField("category_id")
    private Long categoryId;

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




