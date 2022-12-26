package com.liboshuai.mall.admin.module.ums.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.mall.admin.module.ums.domain.entity.UmsAdmin;
import com.liboshuai.mall.admin.module.ums.domain.dto.UmsAdminDTO;
import com.liboshuai.mall.admin.module.ums.domain.vo.UmsAdminVO;
import com.liboshuai.mall.admin.module.ums.mapper.UmsAdminMapper;
import com.liboshuai.mall.admin.module.ums.service.UmsAdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {

    @Autowired
    private UmsAdminMapper umsAdminMapper;


    /**
     * 根据用户名称查询用户id
     */
    @Override
    public Long findUserIdByUserName(String userName) {
        LambdaQueryWrapper<UmsAdmin> umsMemberLambdaQueryWrapper = new LambdaQueryWrapper<>();
        umsMemberLambdaQueryWrapper.eq(UmsAdmin::getUsername, userName);
        return umsAdminMapper.selectOne(umsMemberLambdaQueryWrapper).getId();
    }

    /**
     * 根据用户名称查询用户全部信息
     */
    @Override
    public UmsAdminDTO findByUserName(String username) {
        LambdaQueryWrapper<UmsAdmin> umsMemberLambdaQueryWrapper = new LambdaQueryWrapper<>();
        umsMemberLambdaQueryWrapper.eq(UmsAdmin::getUsername, username);
        UmsAdmin umsAdmin = umsAdminMapper.selectOne(umsMemberLambdaQueryWrapper);
        UmsAdminDTO umsAdminDTO = new UmsAdminDTO();
        if (Objects.nonNull(umsAdmin)) {
            BeanUtils.copyProperties(umsAdmin, umsAdminDTO);
        }
        return umsAdminDTO;
    }

    /**
     * 测试批量更新用户信息
     */
    @Override
    public int updateBatchUserById(List<UmsAdminVO> umsAdminVOList) {
        List<UmsAdmin> umsAdminList = umsAdminVOList.stream().map(umsAdminVO -> {
            UmsAdmin umsAdmin = new UmsAdmin();
            BeanUtils.copyProperties(umsAdminVO, umsAdmin);
            return umsAdmin;
        }).collect(Collectors.toList());
        return umsAdminMapper.updateBatch(umsAdminList);
    }
}
