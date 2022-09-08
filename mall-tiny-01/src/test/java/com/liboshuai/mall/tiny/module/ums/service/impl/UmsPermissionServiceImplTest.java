package com.liboshuai.mall.tiny.module.ums.service.impl;

import com.alibaba.fastjson.JSON;
import com.liboshuai.mall.tiny.MallTiny01Application;
import com.liboshuai.mall.tiny.module.ums.domain.dao.UmsPermission;
import com.liboshuai.mall.tiny.module.ums.service.UmsAdminRoleRelationService;
import com.liboshuai.mall.tiny.module.ums.service.UmsAdminService;
import com.liboshuai.mall.tiny.module.ums.service.UmsPermissionService;
import com.liboshuai.mall.tiny.module.ums.service.UmsRolePermissionRelationService;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MallTiny01Application.class)
public class UmsPermissionServiceImplTest extends TestCase {

    @Autowired
    private UmsAdminService umsAdminService;

    @Autowired
    private UmsAdminRoleRelationService umsAdminRoleRelationService;

    @Autowired
    private UmsRolePermissionRelationService umsRolePermissionRelationService;

    @Autowired
    private UmsPermissionService umsPermissionService;

    private static final String USERNAME = "admin";

    @Test
    public void testFindPermissionsByPermissionIds() {
        Long adminId = umsAdminService.findUserIdByUserName(USERNAME);
        List<Long> roleIds = umsAdminRoleRelationService.findRoleIdsByUserId(adminId);
        List<Long> permissionIds = umsRolePermissionRelationService.findPermissionIdsByRoleIds(roleIds);
        List<UmsPermission> permissions = umsPermissionService.findPermissionsByPermissionIds(permissionIds);
        log.info("\n\n\npermissions: {}\n\n\n", JSON.toJSONString(permissions));
    }

    @Test
    public void testFindPermissionsByUsername() {
        List<UmsPermission> permissions = umsPermissionService.findPermissionsByUsername(USERNAME);
        log.info("\n\n\npermissions: {}\n\n\n", JSON.toJSONString(permissions));
    }
}