package com.liboshuai.polaris.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.polaris.common.domain.BaseEntity;
import lombok.*;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 03:10
 * @Description: 后台用户和角色关系表
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("ums_admin_role_relation")
public class UmsAdminRoleRelationEntity extends BaseEntity {
    private static final long serialVersionUID = 7605607392939642301L;

    /**
     * 用户id
     */
    private Long adminId;

    /**
     * 角色id
     */
    private Long roleId;
}
