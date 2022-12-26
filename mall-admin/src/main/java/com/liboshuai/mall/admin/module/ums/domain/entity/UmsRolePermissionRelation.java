package com.liboshuai.mall.admin.module.ums.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 * 后台用户角色和权限关系表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("ums_role_permission_relation")
@ApiModel(value = "UmsRolePermissionRelation对象", description = "后台用户角色和权限关系表")
public class UmsRolePermissionRelation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("role_id")
    private Long roleId;

    @TableField("permission_id")
    private Long permissionId;

}




