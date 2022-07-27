package com.liboshuai.mall.tiny.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liboshuai.mall.tiny.domain.dao.UmsAdmin;
import com.liboshuai.mall.tiny.domain.dao.UmsPermission;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
public interface UmsAdminService extends IService<UmsAdmin> {

    // todo: 接口待验证
    /**
     * 根据“用户id”查询“权限”信息（包括+-权限）
     * @param adminId 用户id
     * @return 权限信息
     */
    List<UmsPermission> findPermissions(Long adminId);

    String login(String username, String password);

    /**
     * 注册用户
     * @param umsAdminParam 注册的用户信息
     * @return 注册成功的用户信息
     */
    UmsAdmin register(UmsAdmin umsAdminParam);
}
