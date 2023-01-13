package com.liboshuai.polaris.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liboshuai.polaris.security.entity.SysPermissionEntity;

import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2023-01-13 17:14
 * @Description:
 */
public interface SysPermissionService extends IService<SysPermissionEntity> {

    /**
     * 获取登录用户拥有的权限
     */
    List<SysPermissionEntity> queryByUser(String username);
}
