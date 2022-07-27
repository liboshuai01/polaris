package com.liboshuai.mall.tiny.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.liboshuai.mall.tiny.common.enums.UmsPermissionTypeEnum;
import com.liboshuai.mall.tiny.domain.dao.*;
import com.liboshuai.mall.tiny.mapper.*;
import com.liboshuai.mall.tiny.service.UmsAdminService;
import com.liboshuai.mall.tiny.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
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

    private final UmsAdminMapper umsAdminMapper;

    private final PasswordEncoder passwordEncoder;

    private final UserDetailsService userDetailsService;

    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public UmsAdminServiceImpl(UmsAdminRoleRelationMapper umsAdminRoleRelationMapper,
                               UmsRolePermissionRelationMapper umsRolePermissionRelationMapper,
                               UmsAdminPermissionRelationMapper umsAdminPermissionRelationMapper,
                               UmsPermissionMapper umsPermissionMapper,
                               UmsAdminMapper umsAdminMapper,
                               PasswordEncoder passwordEncoder, UserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil) {
        this.umsAdminRoleRelationMapper = umsAdminRoleRelationMapper;
        this.umsRolePermissionRelationMapper = umsRolePermissionRelationMapper;
        this.umsAdminPermissionRelationMapper = umsAdminPermissionRelationMapper;
        this.umsPermissionMapper = umsPermissionMapper;
        this.umsAdminMapper = umsAdminMapper;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
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

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (UsernameNotFoundException e) {
            log.info("登录异常:{}", e.getMessage());
        } catch (BadCredentialsException e) {
            e.printStackTrace();
        }
        return token;
    }

    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        // 查询是否有相同用户名的用户
        LambdaQueryWrapper<UmsAdmin> umsAdminLambdaQueryWrapper = new LambdaQueryWrapper<>();
        umsAdminLambdaQueryWrapper.eq(UmsAdmin::getUsername, umsAdminParam.getUsername());
        List<UmsAdmin> umsAdmins = umsAdminMapper.selectList(umsAdminLambdaQueryWrapper);
        if (umsAdmins.size() > 0) {
            return null;
        }
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setStatus(1);
        umsAdmin.setCreateTime(LocalDateTime.now());
        // 进行密码加密操作
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        umsAdminMapper.insert(umsAdmin);
        return umsAdmin;
    }
}
