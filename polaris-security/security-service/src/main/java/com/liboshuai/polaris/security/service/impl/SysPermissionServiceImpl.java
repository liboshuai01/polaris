package com.liboshuai.polaris.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.polaris.security.entity.SysPermissionEntity;
import com.liboshuai.polaris.security.mapper.SysPermissionMapper;
import com.liboshuai.polaris.security.service.SysPermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2023-01-13 17:32
 * @Description:
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermissionEntity> implements SysPermissionService {
    /**
     * 获取登录用户拥有的权限
     */
    @Override
    public List<SysPermissionEntity> queryByUser(String username) {
        return this.sysPermissionMapper.queryByUser(username);
    }
}
