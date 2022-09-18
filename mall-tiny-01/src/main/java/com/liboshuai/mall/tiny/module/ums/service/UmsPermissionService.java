package com.liboshuai.mall.tiny.module.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liboshuai.mall.tiny.module.ums.domain.entity.UmsPermission;
import com.liboshuai.mall.tiny.module.ums.domain.dto.UmsPermissionDTO;

import java.util.List;

/**
 * <p>
 * 后台用户权限表 服务类
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
public interface UmsPermissionService extends IService<UmsPermission> {
    /**
     * 根据权限id集合查询权限信息
     */
    List<UmsPermissionDTO> findPermissionsByPermissionIds(List<Long> permissionIds);

    /**
     * 根据用户名称获取权限信息
     */
    List<UmsPermissionDTO> findPermissionsByUsername(String username);

    /**
     *  根据角色id集合查询权限信息集合
     */
    List<UmsPermissionDTO> findPermissionsByRoleIds(List<Long> roleIds);
}
