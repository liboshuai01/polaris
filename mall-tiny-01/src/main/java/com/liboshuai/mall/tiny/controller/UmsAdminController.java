package com.liboshuai.mall.tiny.controller;


import com.liboshuai.mall.tiny.common.api.CommonResult;
import com.liboshuai.mall.tiny.domain.dao.UmsPermission;
import com.liboshuai.mall.tiny.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Api(tags = "后台用户", value = "UmsAdminController")
@RestController
@RequestMapping("/mall.tiny/ums-admin")
public class UmsAdminController {

    @Autowired
    private UmsAdminService umsAdminService;

    @ApiOperation(value = "根据用户名获取权限信息", httpMethod = "GET")
    @GetMapping("/findPermissions")
    public CommonResult<List<UmsPermission>> findPermissions(@RequestParam Long adminId) {
        List<UmsPermission> permissions = umsAdminService.findPermissions(adminId);
        return CommonResult.success(permissions);
    }

}
