package com.liboshuai.mall.admin.module.ums.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("ums_admin_permission_relation")
@ApiModel(value = "UmsAdminPermissionRelation对象", description = "后台用户和权限关系表(除角色中定义的权限以外的加减权限)")
public class UmsAdminPermissionRelation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("admin_id")
    private Long adminId;

    @TableField("permission_id")
    private Long permissionId;

    @TableField("type")
    private Integer type;

}




