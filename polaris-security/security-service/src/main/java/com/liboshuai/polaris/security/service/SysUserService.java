package com.liboshuai.polaris.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liboshuai.polaris.common.domain.ResponseResult;
import com.liboshuai.polaris.security.dto.SysUserDTO;
import com.liboshuai.polaris.security.entity.SysUserEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 20:16
 * @Description:
 */
public interface SysUserService extends IService<SysUserEntity> {

    /**
     * 根据用户名查询用户信息
     */
    ResponseResult<SysUserDTO> findUserByName(String username);

    /**
     * 根据用户名更新机构号
     */
    ResponseResult<Boolean> updateOrgCodeByUsername(@Valid @NotNull String username, @Valid @NotNull String orgCode);
}
