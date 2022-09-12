package com.liboshuai.mall.tiny.module.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.mall.tiny.module.ums.domain.dao.UmsRole;
import com.liboshuai.mall.tiny.module.ums.domain.dto.UmsRoleDTO;
import com.liboshuai.mall.tiny.module.ums.mapper.UmsRoleMapper;
import com.liboshuai.mall.tiny.module.ums.service.UmsAdminRoleRelationService;
import com.liboshuai.mall.tiny.module.ums.service.UmsAdminService;
import com.liboshuai.mall.tiny.module.ums.service.UmsRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 后台用户角色表 服务实现类
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Service
public class UmsRoleServiceImpl extends ServiceImpl<UmsRoleMapper, UmsRole> implements UmsRoleService {

    @Autowired
    private UmsAdminService umsAdminService;

    @Autowired
    private UmsAdminRoleRelationService umsAdminRoleRelationService;

    @Autowired
    private UmsRoleService umsRoleService;

    @Autowired
    private UmsRoleMapper umsRoleMapper;

    /**
     * 根据角色id集合查询角色信息
     */
    @Override
    public List<UmsRoleDTO> findRolesByRoleIds(List<Long> roleIds) {
        List<UmsRole> umsRoleList = umsRoleMapper.selectBatchIds(roleIds);
        return umsRoleList.stream()
                .map(umsRole -> {
                    UmsRoleDTO umsRoleDTO = new UmsRoleDTO();
                    BeanUtils.copyProperties(umsRole, umsRoleDTO);
                    return umsRoleDTO;
                })
                .collect(Collectors.toList());
    }

    /**
     * 根据用户名获取角色信息集合
     */
    @Override
    public List<UmsRoleDTO> findRolesByUsername(String username) {
        Long adminId = umsAdminService.findUserIdByUserName("admin");
        List<Long> roleIds = umsAdminRoleRelationService.findRoleIdsByUserId(adminId);
        return umsRoleService.findRolesByRoleIds(roleIds);
    }
}
