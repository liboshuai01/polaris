package com.liboshuai.polaris.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liboshuai.polaris.common.domain.ResponseResult;
import com.liboshuai.polaris.security.dto.SysTenantDTO;
import com.liboshuai.polaris.security.entity.SysTenantEntity;

import java.util.List;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 20:58
 * @Description:
 */
public interface SysTenantService extends IService<SysTenantEntity> {

    /**
     * 根据租户id批量查询租户信息
     */
    ResponseResult<List<SysTenantDTO>> findValidTenants(List<Integer> tenantIdList);
}
