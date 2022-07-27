package com.liboshuai.mall.tiny.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.liboshuai.mall.tiny.common.enums.UmsPermissionTypeEnum;
import com.liboshuai.mall.tiny.domain.dao.*;
import com.liboshuai.mall.tiny.mapper.*;
import com.liboshuai.mall.tiny.service.UmsAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Slf4j
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {

    private final UmsAdminRoleRelationMapper umsAdminRoleRelationMapper;

    private final UmsRolePermissionRelationMapper umsRolePermissionRelationMapper;

    private final UmsAdminPermissionRelationMapper umsAdminPermissionRelationMapper;

    private final UmsPermissionMapper umsPermissionMapper;

    @Autowired
    public UmsAdminServiceImpl(UmsAdminRoleRelationMapper umsAdminRoleRelationMapper,
                               UmsRolePermissionRelationMapper umsRolePermissionRelationMapper,
                               UmsAdminPermissionRelationMapper umsAdminPermissionRelationMapper,
                               UmsPermissionMapper umsPermissionMapper) {
        this.umsAdminRoleRelationMapper = umsAdminRoleRelationMapper;
        this.umsRolePermissionRelationMapper = umsRolePermissionRelationMapper;
        this.umsAdminPermissionRelationMapper = umsAdminPermissionRelationMapper;
        this.umsPermissionMapper = umsPermissionMapper;
    }


    @Override
    public List<UmsPermission> findPermissions(Long adminId) {
        // adminId -> umsAdminRoleRelationMapper -> roleIds -> umsRolePermissionRelationMapper -> permissionIds
        LambdaQueryWrapper<UmsAdminRoleRelation> umsAdminRoleRelationLambdaQueryWrapper = new LambdaQueryWrapper<>();
        umsAdminRoleRelationLambdaQueryWrapper.eq(UmsAdminRoleRelation::getAdminId, adminId);
        List<UmsAdminRoleRelation> umsAdminRoleRelations = umsAdminRoleRelationMapper
                .selectList(umsAdminRoleRelationLambdaQueryWrapper);
        if (CollectionUtils.isEmpty(umsAdminRoleRelations)) {
            log.info("通过adminId查询UmsAdminRoleRelation结果值为空");
            return Lists.newArrayList();
        }
        List<Long> roleIds = umsAdminRoleRelations.stream()
                .map(UmsAdminRoleRelation::getRoleId)
                .distinct()
                .collect(Collectors.toList());
        LambdaQueryWrapper<UmsRolePermissionRelation> umsRolePermissionRelationLambdaQueryWrapper =
                new LambdaQueryWrapper<>();
        umsRolePermissionRelationLambdaQueryWrapper.in(UmsRolePermissionRelation::getRoleId, roleIds);
        List<UmsRolePermissionRelation> umsRolePermissionRelations =
                umsRolePermissionRelationMapper.selectList(umsRolePermissionRelationLambdaQueryWrapper);
        if (CollectionUtils.isEmpty(umsRolePermissionRelations)) {
            log.info("通过roleId查询UmsRolePermissionRelation结果值为空");
            return Lists.newArrayList();
        }
        List<Long> permissionIds = umsRolePermissionRelations.stream()
                .map(UmsRolePermissionRelation::getPermissionId)
                .distinct()
                .collect(Collectors.toList());

        // admin -> umsAdminPermissionRelationMapper -> permissionList
        LambdaQueryWrapper<UmsAdminPermissionRelation> umsAdminPermissionRelationLambdaQueryWrapper =
                new LambdaQueryWrapper<>();
        umsAdminPermissionRelationLambdaQueryWrapper.eq(UmsAdminPermissionRelation::getAdminId, adminId);
        List<UmsAdminPermissionRelation> umsAdminPermissionRelations =
                umsAdminPermissionRelationMapper.selectList(umsAdminPermissionRelationLambdaQueryWrapper);
        if (CollectionUtils.isEmpty(umsAdminPermissionRelations)) {
            log.info("通过roleId查询UmsAdminPermissionRelation结果值为空-02");
            return Lists.newArrayList();
        }
        List<Long> permissionList = umsAdminPermissionRelations.stream()
                .map(UmsAdminPermissionRelation::getPermissionId)
                .distinct()
                .collect(Collectors.toList());

        // permissionList -> umsPermissionMapper -> umsPermissions
        LambdaQueryWrapper<UmsPermission> umsPermissionLambdaQueryWrapper = new LambdaQueryWrapper<>();
        umsPermissionLambdaQueryWrapper.in(UmsPermission::getId, permissionList);
        List<UmsPermission> umsPermissions = umsPermissionMapper.selectList(umsPermissionLambdaQueryWrapper);
        if (CollectionUtils.isEmpty(umsPermissions)) {
            log.info("通过permissionList查询umsPermissions结果值为空");
            return Lists.newArrayList();
        }

        // umsPermissions -> type=-1或1 -> getId() -> permissionIdOnes和permissionIdTwos
        Map<Integer, List<UmsPermission>> typeUmsPermissionMap = umsPermissions.stream()
                .collect(Collectors.groupingBy(UmsPermission::getType));
        List<Long> permissionIdOnes = typeUmsPermissionMap.get(UmsPermissionTypeEnum.PERMISSION_TYPE_REDUCE.getCode()).stream()
                .map(UmsPermission::getId)
                .collect(Collectors.toList());
        List<Long> permissionIdTwos = typeUmsPermissionMap.get(UmsPermissionTypeEnum.PERMISSION_TYPE_PLUS.getCode()).stream()
                .map(UmsPermission::getId)
                .collect(Collectors.toList());

        // permissionIds 减 permissionIdOnes
        permissionIds.removeAll(permissionIdOnes);
        // permissionIds 加 permissionIdTwos
        permissionIds.addAll(permissionIdTwos);

        // permissionIds -> umsPermissionMapper -> umsPermissionList
        LambdaQueryWrapper<UmsPermission> umsPermissionLambdaQueryWrapperTwo = new LambdaQueryWrapper<>();
        umsPermissionLambdaQueryWrapperTwo.in(UmsPermission::getId, permissionIds);
        return umsPermissionMapper.selectList(umsPermissionLambdaQueryWrapperTwo);
    }
}
