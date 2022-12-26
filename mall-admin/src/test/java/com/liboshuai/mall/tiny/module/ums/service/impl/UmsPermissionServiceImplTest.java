package com.liboshuai.mall.tiny.module.ums.service.impl;

import com.liboshuai.mall.tiny.MallAdminApplication;
import com.liboshuai.mall.tiny.module.ums.domain.dto.UmsPermissionDTO;
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
@SpringBootTest(classes = MallAdminApplication.class)
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
        List<UmsPermissionDTO> permissions = umsPermissionService.findPermissionsByPermissionIds(permissionIds);
    }

    @Test
    public void testFindPermissionsByUsername() {
        List<UmsPermissionDTO> permissions = umsPermissionService.findPermissionsByUsername(USERNAME);
        log.debug("这是我写完的新需求代码!");
    }
}