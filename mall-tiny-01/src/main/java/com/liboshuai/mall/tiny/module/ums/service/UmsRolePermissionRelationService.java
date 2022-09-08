package com.liboshuai.mall.tiny.module.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liboshuai.mall.tiny.module.ums.domain.dao.UmsRolePermissionRelation;

import java.util.List;

/**
 * <p>
 * 后台用户角色和权限关系表 服务类
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
public interface UmsRolePermissionRelationService extends IService<UmsRolePermissionRelation> {

    /**
     * 根据角色id集合查询权限id集合
     */
    List<Long> findPermissionIdsByRoleIds(List<Long> roleIds);
}
