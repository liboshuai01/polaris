package com.liboshuai.mall.admin.module.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liboshuai.mall.admin.module.ums.domain.entity.UmsAdmin;
import com.liboshuai.mall.admin.module.ums.domain.dto.UmsAdminDTO;
import com.liboshuai.mall.admin.module.ums.domain.vo.UmsAdminVO;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
public interface UmsAdminService extends IService<UmsAdmin> {


    /**
     * 根据用户名称查询用户id
     */
    Long findUserIdByUserName(String userName);

    /**
     * 根据用户名称查询用户全部信息
     */
    UmsAdminDTO findByUserName(String username);

    /**
     * 测试批量更新用户信息
     */
    int updateBatchUserById(List<UmsAdminVO> umsAdminVOList);
}