package com.liboshuai.mall.admin.module.ums.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 后台用户权限表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("ums_permission")
@ApiModel(value = "UmsPermission对象", description = "后台用户权限表")
public class UmsPermission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("父级权限id")
    @TableField("pid")
    private Long pid;

    @ApiModelProperty("名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("权限值")
    @TableField("value")
    private String value;

    @ApiModelProperty("图标")
    @TableField("icon")
    private String icon;

    @ApiModelProperty("权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）")
    @TableField("type")
    private Integer type;

    @ApiModelProperty("前端资源路径")
    @TableField("uri")
    private String uri;

    @ApiModelProperty("启用状态；0->禁用；1->启用")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("排序")
    @TableField("sort")
    private Integer sort;

}




