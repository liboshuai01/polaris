package com.liboshuai.mall.tiny.service;

import com.liboshuai.mall.tiny.domain.dao.UmsAdmin;
import com.liboshuai.mall.tiny.domain.dao.UmsPermission;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2022-07-10 20:35
 * @Description: 请求返回码
 */
@Service
public interface UmsAdminService {

    /**
     * 根据 用户名 查询 后台用户信息
     *
     * @param username 用户名
     * @return 后台用户信息
     */
    UmsAdmin findAllByUsername(String username);

    /**
     * ho'q
     * @param id
     * @return
     */
    List<UmsPermission> findPermissions(Long id);
}
