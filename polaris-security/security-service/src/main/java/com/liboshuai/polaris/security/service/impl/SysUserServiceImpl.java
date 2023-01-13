package com.liboshuai.polaris.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.polaris.common.domain.ResponseResult;
import com.liboshuai.polaris.security.dto.SysUserDTO;
import com.liboshuai.polaris.security.entity.SysRoleIndexEntity;
import com.liboshuai.polaris.security.entity.SysUserEntity;
import com.liboshuai.polaris.security.mapper.SysUserMapper;
import com.liboshuai.polaris.security.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 20:17
 * @Description:
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {


    /**
     * 根据用户名查询用户信息
     */
    @Override
    public ResponseResult<SysUserDTO> findUserByName(String username) {
        LambdaQueryWrapper<SysUserEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUserEntity::getUsername,username);
        SysUserEntity sysUserEntity = super.getOne(queryWrapper);
        SysUserDTO sysUserDTO = new SysUserDTO();
        BeanUtils.copyProperties(sysUserEntity, sysUserDTO);
        return ResponseResult.success(sysUserDTO);
    }

    /**
     * 根据用户名更新机构号
     */
    @Override
    public ResponseResult<Boolean> updateOrgCodeByUsername(@Valid @NotNull String username, @Valid @NotNull String orgCode) {
        LambdaQueryWrapper<SysUserEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUserEntity::getUsername, username);
        SysUserEntity sysUserEntity = super.getOne(wrapper);
        sysUserEntity.setOrgCode(orgCode);
        boolean result = super.updateById(sysUserEntity);
        return ResponseResult.success(result);
    }

    @Override
    public SysUserEntity getUserByName(String username) {
        return null;
    }

    @Override
    public SysRoleIndexEntity getDynamicIndexByUserRole(String username, String version) {
        return null;
    }
}
