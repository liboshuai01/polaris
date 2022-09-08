package com.liboshuai.mall.tiny.module.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liboshuai.mall.tiny.common.api.ResponseResult;
import com.liboshuai.mall.tiny.module.ums.domain.dao.UmsAdmin;
import com.liboshuai.mall.tiny.module.ums.domain.dao.UmsPermission;

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

    /**
     * 根据用户名称查询用户id
     */
    Long findUserIdByUserName(String userName);
}
