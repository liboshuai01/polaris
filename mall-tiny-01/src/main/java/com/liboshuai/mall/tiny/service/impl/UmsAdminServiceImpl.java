package com.liboshuai.mall.tiny.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.liboshuai.mall.tiny.domain.dao.UmsAdmin;
import com.liboshuai.mall.tiny.domain.dao.UmsPermission;
import com.liboshuai.mall.tiny.mapper.UmsAdminMapper;
import com.liboshuai.mall.tiny.service.UmsAdminService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@NoArgsConstructor
public class UmsAdminServiceImpl implements UmsAdminService {

    private UmsAdminMapper umsAdminMapper;

    @Autowired
    public UmsAdminServiceImpl(UmsAdminMapper umsAdminMapper) {
        this.umsAdminMapper = umsAdminMapper;
    }

    /**
     * 根据 用户名 查询 后台用户信息
     *
     * @param username 用户名
     * @return 后台用户信息
     */
    @Override
    public UmsAdmin findAllByUsername(String username) {
        LambdaQueryWrapper<UmsAdmin> umsAdminLambdaQueryWrapper = new LambdaQueryWrapper<>();
        umsAdminLambdaQueryWrapper.eq(UmsAdmin::getUsername, username);
        return umsAdminMapper.selectOne(umsAdminLambdaQueryWrapper);
    }

    /**
     * ho'q
     *
     * @param id
     * @return
     */
    @Override
    public List<UmsPermission> findPermissions(Long id) {
        return null;
    }
}
