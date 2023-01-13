package com.liboshuai.polaris.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.polaris.common.domain.ResponseResult;
import com.liboshuai.polaris.security.dto.SysDepartDTO;
import com.liboshuai.polaris.security.entity.SysDepartEntity;
import com.liboshuai.polaris.security.entity.SysUserDepartEntity;
import com.liboshuai.polaris.security.mapper.SysDepartMapper;
import com.liboshuai.polaris.security.mapper.SysUserDepartMapper;
import com.liboshuai.polaris.security.service.SysDepartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 21:39
 * @Description:
 */
@Service
public class SysDepartServiceImpl extends ServiceImpl<SysDepartMapper, SysDepartEntity> implements SysDepartService {

    @Autowired
    private SysUserDepartMapper sysUserDepartMapper;
    @Autowired
    private SysDepartMapper sysDepartMapper;

    /**
     * 据用户id查询机构集合
     */
    @Override
    public ResponseResult<List<SysDepartDTO>> findDepartsByUserId(String userId) {
        LambdaQueryWrapper<SysUserDepartEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUserDepartEntity::getUserId, userId);
        List<SysUserDepartEntity> sysUserDepartEntities = sysUserDepartMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(sysUserDepartEntities)) {
            return ResponseResult.success(null);
        }
        List<String> depIdList = sysUserDepartEntities.stream().map(SysUserDepartEntity::getDepId).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(depIdList)) {
            return ResponseResult.success(null);
        }
        List<SysDepartEntity> departEntities = sysDepartMapper.selectBatchIds(depIdList);
        if (CollectionUtils.isEmpty(departEntities)) {
            return ResponseResult.success(null);
        }
        List<SysDepartDTO> sysDepartDTOList = departEntities.stream().map(sysDepartEntity -> {
            SysDepartDTO sysDepartDTO = new SysDepartDTO();
            BeanUtils.copyProperties(sysDepartEntity, sysDepartDTO);
            return sysDepartDTO;
        }).collect(Collectors.toList());
        return ResponseResult.success(sysDepartDTOList);
    }
}
