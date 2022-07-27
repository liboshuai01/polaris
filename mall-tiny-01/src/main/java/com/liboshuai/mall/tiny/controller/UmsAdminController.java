package com.liboshuai.mall.tiny.controller;


import com.liboshuai.mall.tiny.common.api.CommonResult;
import com.liboshuai.mall.tiny.domain.dao.UmsAdmin;
import com.liboshuai.mall.tiny.domain.dao.UmsPermission;
import com.liboshuai.mall.tiny.domain.dto.UmsAdminLoginParam;
import com.liboshuai.mall.tiny.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "根据用户名获取权限信息", httpMethod = "GET")
    @GetMapping("/findPermissions")
    public CommonResult<List<UmsPermission>> findPermissions(@RequestParam Long adminId) {
        List<UmsPermission> permissions = umsAdminService.findPermissions(adminId);
        return CommonResult.success(permissions);
    }

    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    public CommonResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdminParam, BindingResult result) {
        UmsAdmin umsAdmin = umsAdminService.register(umsAdminParam);
        if (Objects.nonNull(umsAdmin)) {
            CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "登录", httpMethod = "POST")
    @PostMapping(value = "/login")
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
        String token = umsAdminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (Objects.isNull(token)) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        HashMap<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }
}
