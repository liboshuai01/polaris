package com.liboshuai.mall.admin.module.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.mall.admin.module.ums.domain.entity.UmsPermission;
import com.liboshuai.mall.admin.module.ums.domain.dto.UmsPermissionDTO;
import com.liboshuai.mall.admin.module.ums.mapper.UmsPermissionMapper;
import com.liboshuai.mall.admin.module.ums.service.UmsAdminRoleRelationService;
import com.liboshuai.mall.admin.module.ums.service.UmsAdminService;
import com.liboshuai.mall.admin.module.ums.service.UmsPermissionService;
import com.liboshuai.mall.admin.module.ums.service.UmsRolePermissionRelationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 后台用户权限表 服务实现类
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Service
public class UmsPermissionServiceImpl extends ServiceImpl<UmsPermissionMapper, UmsPermission> implements UmsPermissionService {
    @Autowired
    private UmsAdminService umsAdminService;

    @Autowired
    private UmsAdminRoleRelationService umsAdminRoleRelationService;

    @Autowired
    private UmsRolePermissionRelationService umsRolePermissionRelationService;

    @Autowired
    private UmsPermissionMapper umsPermissionMapper;

    /**
     * 根据权限id集合查询权限信息
     */
    @Override
    public List<UmsPermissionDTO> findPermissionsByPermissionIds(List<Long> permissionIds) {
        List<UmsPermission> permissionList = umsPermissionMapper.selectBatchIds(permissionIds);
        return permissionList.stream()
                .map(umsPermission -> {
                    UmsPermissionDTO umsPermissionDTO = new UmsPermissionDTO();
                    BeanUtils.copyProperties(umsPermission, umsPermissionDTO);
                    return umsPermissionDTO;
                })
                .collect(Collectors.toList());
    }

    /**
     * 根据用户名称获取权限信息
     */
    @Override
    public List<UmsPermissionDTO> findPermissionsByUsername(String username) {
        Long adminId = umsAdminService.findUserIdByUserName(username);
        List<Long> roleIds = umsAdminRoleRelationService.findRoleIdsByUserId(adminId);
        List<Long> permissionIds = umsRolePermissionRelationService.findPermissionIdsByRoleIds(roleIds);
        return this.findPermissionsByPermissionIds(permissionIds);
    }

    /**
     * 根据角色id集合查询权限信息集合
     */
    @Override
    public List<UmsPermissionDTO> findPermissionsByRoleIds(List<Long> roleIds) {
        List<Long> permissionIds = umsRolePermissionRelationService.findPermissionIdsByRoleIds(roleIds);
        return this.findPermissionsByPermissionIds(permissionIds);
    }
}
