package com.liboshuai.mall.tiny.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.mall.tiny.domain.dao.UmsAdmin;
import com.liboshuai.mall.tiny.domain.dao.UmsPermission;
import com.liboshuai.mall.tiny.mapper.UmsAdminMapper;
import com.liboshuai.mall.tiny.service.UmsAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Slf4j
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {

    /**
     * 根据“用户id”查询“权限”信息（包括+-权限）
     *
     * @param adminId 用户id
     * @return 权限信息
     */
    @Override
    public List<UmsPermission> findPermissions(Long adminId) {
        return null;
    }

    @Override
    public String login(String username, String password) {
        return null;
    }

    /**
     * 注册用户
     *
     * @param umsAdminParam 注册的用户信息
     * @return 注册成功的用户信息
     */
    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        return null;
    }
}
