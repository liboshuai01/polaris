package com.liboshuai.mall.tiny.module.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liboshuai.mall.tiny.module.ums.domain.dao.UmsAdminRoleRelation;

import java.util.List;

/**
 * <p>
 * 后台用户和角色关系表 服务类
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
public interface UmsAdminRoleRelationService extends IService<UmsAdminRoleRelation> {

    /**
     * 根据用户id查询角色id集合
     */
    List<Long> findRoleIdsByUserId(Long userId);

}
