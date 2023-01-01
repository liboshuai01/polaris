package com.liboshuai.polaris.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.polaris.common.domain.BaseEntity;
import lombok.*;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 03:07
 * @Description: 后台用户和权限关系表(除角色中定义的权限以外的加减权限)
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("ums_admin_permission_relation")
public class UmsAdminPermissionRelationEntity extends BaseEntity {
    private static final long serialVersionUID = 7445978899797394043L;

    /**
     * 用户id
     */
    private Long adminId;

    /**
     * 权限id
     */
    private Long permissionId;

    /**
     * 类型：0-减权限，1-加权限
     */
    private Integer type;

}
