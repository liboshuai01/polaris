package com.liboshuai.mall.tiny.module.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.mall.tiny.module.ums.domain.dao.UmsPermission;
import com.liboshuai.mall.tiny.module.ums.mapper.UmsPermissionMapper;
import com.liboshuai.mall.tiny.module.ums.service.UmsPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台用户权限表 服务实现类
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Service
public class UmsPermissionServiceImpl extends ServiceImpl<UmsPermissionMapper, UmsPermission> implements UmsPermissionService {

    @Autowired
    private UmsPermissionMapper umsPermissionMapper;

    /**
     * 根据权限id集合查询权限信息
     */
    @Override
    public List<UmsPermission> findPermissionsByPermissionIds(List<Long> permissionIds) {
        return umsPermissionMapper.selectBatchIds(permissionIds);
    }

}
