package com.liboshuai.mall.admin.module.ums.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.mall.admin.module.ums.domain.entity.UmsAdminRoleRelation;
import com.liboshuai.mall.admin.module.ums.mapper.UmsAdminRoleRelationMapper;
import com.liboshuai.mall.admin.module.ums.service.UmsAdminRoleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 后台用户和角色关系表 服务实现类
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Service
public class UmsAdminRoleRelationServiceImpl extends ServiceImpl<UmsAdminRoleRelationMapper, UmsAdminRoleRelation> implements UmsAdminRoleRelationService {
    @Autowired
    private UmsAdminRoleRelationMapper umsAdminRoleRelationMapper;

    /**
     * 根据用户id查询角色id集合
     */
    @Override
    public List<Long> findRoleIdsByUserId(Long userId) {
        LambdaQueryWrapper<UmsAdminRoleRelation> umsAdminRoleRelationLambdaQueryWrapper = new LambdaQueryWrapper<>();
        umsAdminRoleRelationLambdaQueryWrapper.eq(UmsAdminRoleRelation::getAdminId, userId);
        List<UmsAdminRoleRelation> umsAdminRoleRelations = umsAdminRoleRelationMapper.selectList(umsAdminRoleRelationLambdaQueryWrapper);
        return umsAdminRoleRelations.stream().map(UmsAdminRoleRelation::getRoleId).collect(Collectors.toList());
    }
}
