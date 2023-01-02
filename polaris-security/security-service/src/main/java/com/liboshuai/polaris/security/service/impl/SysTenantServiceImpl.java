package com.liboshuai.polaris.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.polaris.common.domain.ResponseResult;
import com.liboshuai.polaris.common.enums.CommonStatusEnum;
import com.liboshuai.polaris.security.dto.SysTenantDTO;
import com.liboshuai.polaris.security.entity.SysTenantEntity;
import com.liboshuai.polaris.security.mapper.SysTenantMapper;
import com.liboshuai.polaris.security.service.SysTenantService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 21:08
 * @Description:
 */
@Service
public class SysTenantServiceImpl extends ServiceImpl<SysTenantMapper, SysTenantEntity> implements SysTenantService {
    /**
     * 根据租户id批量查询有效的租户信息
     */
    @Override
    public ResponseResult<List<SysTenantDTO>> findValidTenants(List<Integer> tenantIdList) {
        LambdaQueryWrapper<SysTenantEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(SysTenantEntity::getId, tenantIdList);
        queryWrapper.eq(SysTenantEntity::getStatus, CommonStatusEnum.VALID.getStatusCode());
        //此处查询忽略时间条件
        List<SysTenantEntity> sysTenantEntities = super.list(queryWrapper);
        List<SysTenantDTO> sysTenantDTOS = new ArrayList<>();
        if (CollectionUtils.isEmpty(sysTenantEntities)) {
            sysTenantDTOS = sysTenantEntities.stream().map(sysTenantEntity -> {
                SysTenantDTO sysTenantDTO = new SysTenantDTO();
                BeanUtils.copyProperties(sysTenantEntity,sysTenantDTO);
                return sysTenantDTO;
            }).collect(Collectors.toList());
        }
        return ResponseResult.success(sysTenantDTOS);
    }
}
