package com.liboshuai.polaris.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.polaris.common.domain.BaseEntity;
import lombok.*;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 03:19
 * @Description: 后台用户权限表
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("ums_permission")
public class UmsPermissionEntity extends BaseEntity {
    private static final long serialVersionUID = 2443265343187328344L;

    /**
     * 父级权限id
     */
    private Long pid;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限值
     */
    private String value;
}
