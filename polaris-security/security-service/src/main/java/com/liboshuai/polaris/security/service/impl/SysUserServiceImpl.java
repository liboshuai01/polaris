package com.liboshuai.polaris.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.polaris.common.constants.CommonConstant;
import com.liboshuai.polaris.common.domain.ResponseResult;
import com.liboshuai.polaris.common.enums.RoleIndexConfigEnum;
import com.liboshuai.polaris.common.utils.oConvertUtils;
import com.liboshuai.polaris.security.dto.SysUserDTO;
import com.liboshuai.polaris.security.entity.SysRoleIndexEntity;
import com.liboshuai.polaris.security.entity.SysUserEntity;
import com.liboshuai.polaris.security.mapper.SysRoleIndexMapper;
import com.liboshuai.polaris.security.mapper.SysUserMapper;
import com.liboshuai.polaris.security.mapper.SysUserRoleMapper;
import com.liboshuai.polaris.security.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 20:17
 * @Description:
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {

    private SysUserRoleMapper sysUserRoleMapper;
    private SysRoleIndexMapper sysRoleIndexMapper;

    @Autowired
    public SysUserServiceImpl(SysUserRoleMapper sysUserRoleMapper, SysRoleIndexMapper sysRoleIndexMapper) {
        this.sysUserRoleMapper = sysUserRoleMapper;
        this.sysRoleIndexMapper = sysRoleIndexMapper;
    }

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
    public SysRoleIndexEntity getDynamicIndexByUserRole(String username, String version) {
        List<String> roles = sysUserRoleMapper.getRoleByUserName(username);
        String componentUrl = RoleIndexConfigEnum.getIndexByRoles(roles);
        SysRoleIndexEntity roleIndex = new SysRoleIndexEntity(componentUrl);
        //只有 X-Version=v3 的时候，才读取sys_role_index表获取角色首页配置
        if (oConvertUtils.isNotEmpty(version) && roles!=null && roles.size()>0) {
            LambdaQueryWrapper<SysRoleIndexEntity> routeIndexQuery = new LambdaQueryWrapper();
            //用户所有角色
            routeIndexQuery.in(SysRoleIndexEntity::getRoleCode, roles);
            //角色首页状态0：未开启  1：开启
            routeIndexQuery.eq(SysRoleIndexEntity::getStatus, CommonConstant.STATUS_1);
            //优先级正序排序
            routeIndexQuery.orderByAsc(SysRoleIndexEntity::getPriority);
            List<SysRoleIndexEntity> list = sysRoleIndexMapper.selectList(routeIndexQuery);
            if (null != list && list.size() > 0) {
                roleIndex = list.get(0);
            }
        }
        //如果componentUrl为空，则返回空
        if(oConvertUtils.isEmpty(roleIndex.getComponent())){
            return null;
        }
        return roleIndex;
    }
}
