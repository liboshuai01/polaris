package com.liboshuai.mall.tiny.module.ums.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.mall.tiny.module.ums.domain.dao.UmsRole;
import com.liboshuai.mall.tiny.module.ums.mapper.UmsRoleMapper;
import com.liboshuai.mall.tiny.module.ums.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台用户角色表 服务实现类
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Service
public class UmsRoleServiceImpl extends ServiceImpl<UmsRoleMapper, UmsRole> implements UmsRoleService {

    @Autowired
    private UmsRoleMapper umsRoleMapper;

    /**
     * 根据角色id集合查询角色信息
     */
    @Override
    public List<UmsRole> findRolesByRoleIds(List<Long> roleIds) {
        return umsRoleMapper.selectBatchIds(roleIds);
    }
}
