package com.liboshuai.mall.admin.module.ums.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 后台用户角色表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("ums_role")
@ApiModel(value = "UmsRole对象", description = "后台用户角色表")
public class UmsRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("后台用户数量")
    @TableField("admin_count")
    private Integer adminCount;

    @ApiModelProperty("启用状态：0->禁用；1->启用")
    @TableField("status")
    private Integer status;

    @TableField("sort")
    private Integer sort;

}




