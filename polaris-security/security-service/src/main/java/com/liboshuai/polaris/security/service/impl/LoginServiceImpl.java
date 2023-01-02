package com.liboshuai.polaris.security.service.impl;

import com.liboshuai.polaris.common.constants.SymbolConstant;
import com.liboshuai.polaris.common.domain.ResponseResult;
import com.liboshuai.polaris.security.dto.SysDepartDTO;
import com.liboshuai.polaris.security.dto.SysDictItemDTO;
import com.liboshuai.polaris.security.dto.SysTenantDTO;
import com.liboshuai.polaris.security.dto.SysUserDTO;
import com.liboshuai.polaris.security.entity.SysUserEntity;
import com.liboshuai.polaris.security.query.LoginQuery;
import com.liboshuai.polaris.security.service.*;
import com.liboshuai.polaris.security.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 19:50
 * @Description:
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysDictItemService sysDictItemService;
    @Autowired
    private SysTenantService sysTenantService;
    @Autowired
    private SysDepartService sysDepartService;

    private static final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NzI2NTY1MzYsInVzZXJuYW1lIjoiamVlY2cifQ.vcAoxbnffdmaEF22d8FJMZcdRYf-d0sMgQT6JTUc_Gg";


    /**
     * 用户登录
     */
    @Override
    public ResponseResult<SysUserInfoVO> login(LoginQuery loginQuery) {
        // todo: 临时进行登录模拟，返回用户信息
        SysUserInfoVO sysUserInfoVO = new SysUserInfoVO();
        // setToken
        sysUserInfoVO.setToken(TOKEN);
        // setSysAllDictItems
        ResponseResult<Map<String, List<SysDictItemDTO>>> queryAllDictItems = sysDictItemService.queryAllDictItems();
        if (Objects.nonNull(queryAllDictItems) && queryAllDictItems.isSuccess()
                && !CollectionUtils.isEmpty(queryAllDictItems.getResult())) {
            sysUserInfoVO.setSysAllDictItems(sysDictDTOMap2VOMap(queryAllDictItems));
        }
        // setUserInfo
        ResponseResult<SysUserDTO> userByName = sysUserService.findUserByName(loginQuery.getUsername());
        if (Objects.isNull(userByName) || !userByName.isSuccess() || Objects.isNull(userByName.getResult())) {
            return ResponseResult.fail("不存在此用户");
        }
        SysUserDTO sysUserDTO = userByName.getResult();
        SysUserVO sysUserVO = new SysUserVO();
        BeanUtils.copyProperties(sysUserDTO, sysUserVO);
        sysUserInfoVO.setUserInfo(sysUserVO);
        // setTenantList
        String tenantIds = sysUserDTO.getRelTenantIds();
        if (StringUtils.isNotEmpty(tenantIds)) {
            List<Integer> tenantIdList = new ArrayList<>();
            for(String id: tenantIds.split(SymbolConstant.COMMA)){
                tenantIdList.add(Integer.valueOf(id));
            }
            // 该方法仅查询有效的租户，如果返回0个就说明所有的租户均无效。
            ResponseResult<List<SysTenantDTO>> queryEffectiveTenant = sysTenantService.findValidTenants(tenantIdList);
            if (Objects.isNull(queryEffectiveTenant) || !queryEffectiveTenant.isSuccess()) {
                return ResponseResult.fail("查询用户的租户信息失败");
            }
            if (CollectionUtils.isEmpty(queryEffectiveTenant.getResult())) {
                return ResponseResult.fail("与该用户关联的租户均已被冻结，无法登录！");
            }
            List<SysTenantDTO> sysTenantDTOS = queryEffectiveTenant.getResult();
            List<SysTenantVO> sysTenantVOS = sysTenantDTOS.stream().map(sysTenantDTO -> {
                SysTenantVO sysTenantVO = new SysTenantVO();
                BeanUtils.copyProperties(sysTenantDTO, sysTenantVO);
                return sysTenantVO;
            }).collect(Collectors.toList());
            sysUserInfoVO.setTenantList(sysTenantVOS);
        }
        // setDeparts and setMulti_depart
        ResponseResult<List<SysDepartDTO>> queryUserDeparts = sysDepartService.findDepartsByUserId(sysUserDTO.getId());
        if (Objects.isNull(queryUserDeparts) || !queryUserDeparts.isSuccess()) {
            sysUserInfoVO.setDeparts(Collections.emptyList());
            sysUserInfoVO.setMulti_depart(0);
        } else {
            List<SysDepartDTO> sysDepartDTOS = queryUserDeparts.getResult();
            if (!CollectionUtils.isEmpty(sysDepartDTOS)) {
                List<SysDepartVO> sysDepartVOS = sysDepartDTOS.stream().map(sysDepartDTO -> {
                    SysDepartVO sysDepartVO = new SysDepartVO();
                    BeanUtils.copyProperties(sysDepartDTO, sysDepartDTO);
                    return sysDepartVO;
                }).collect(Collectors.toList());
                sysUserInfoVO.setDeparts(sysDepartVOS);
            }
            if (sysDepartDTOS == null || sysDepartDTOS.size() == 0) {
                sysUserInfoVO.setMulti_depart(0);
            } else if (sysDepartDTOS.size() == 1) {
                sysUserService.updateOrgCodeByUsername(sysUserDTO.getUsername(), sysDepartDTOS.get(0).getOrgCode());
                sysUserInfoVO.setMulti_depart(1);
            } else {
                //查询当前是否有登录部门
                // update-begin--Author:wangshuai Date:20200805 for：如果用戶为选择部门，数据库为存在上一次登录部门，则取一条存进去
                SysUserEntity sysUserById = sysUserService.getById(sysUserDTO.getId());
                if(StringUtils.isEmpty(sysUserById.getOrgCode())){
                    sysUserService.updateOrgCodeByUsername(sysUserDTO.getUsername(), sysDepartDTOS.get(0).getOrgCode());
                }
                // update-end--Author:wangshuai Date:20200805 for：如果用戶为选择部门，数据库为存在上一次登录部门，则取一条存进去
                sysUserInfoVO.setMulti_depart(2);
            }
        }
        return ResponseResult.success(sysUserInfoVO);
    }

    private Map<String, List<SysDictItemVO>> sysDictDTOMap2VOMap(ResponseResult<Map<String, List<SysDictItemDTO>>> queryAllDictItems) {
        Map<String, List<SysDictItemVO>> sysDictVOMap = new HashMap<>();
        for (Map.Entry<String, List<SysDictItemDTO>> entry:
                queryAllDictItems.getResult().entrySet()){
            if (!CollectionUtils.isEmpty(entry.getValue())) {
                List<SysDictItemVO> sysDictItemVOS = entry.getValue().stream().map(value -> {
                    SysDictItemVO sysDictItemVO = new SysDictItemVO();
                    BeanUtils.copyProperties(value, sysDictItemVO);
                    return sysDictItemVO;
                }).collect(Collectors.toList());
                sysDictVOMap.put(entry.getKey(), sysDictItemVOS);
            }
        }
        return sysDictVOMap;
    }
}
