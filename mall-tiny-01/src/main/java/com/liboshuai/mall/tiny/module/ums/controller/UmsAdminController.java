package com.liboshuai.mall.tiny.module.ums.controller;


import com.liboshuai.mall.tiny.common.api.ResponseResult;
import com.liboshuai.mall.tiny.module.ums.domain.dao.UmsAdmin;
import com.liboshuai.mall.tiny.module.ums.domain.dao.UmsPermission;
import com.liboshuai.mall.tiny.module.ums.domain.dto.UmsAdminLoginParam;
import com.liboshuai.mall.tiny.module.ums.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UmsAdminController {

    @Autowired
    private UmsAdminService umsAdminService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "根据用户名获取权限信息", httpMethod = "GET")
    @GetMapping("/findPermissions")
    public ResponseResult<List<UmsPermission>> findPermissions(@RequestParam Long adminId) {
        List<UmsPermission> permissions = umsAdminService.findPermissions(adminId);
        return ResponseResult.success(permissions);
    }

    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    public ResponseResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdminParam, BindingResult result) {
        UmsAdmin umsAdmin = umsAdminService.register(umsAdminParam);
        if (Objects.nonNull(umsAdmin)) {
            ResponseResult.failed();
        }
        return ResponseResult.success(umsAdmin);
    }

    @ApiOperation(value = "登录", httpMethod = "POST")
    @PostMapping(value = "/login")
    public ResponseResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
        log.info("------开始进行用户登录------");
        String token = umsAdminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (Objects.isNull(token)) {
            return ResponseResult.validateFailed("用户名或密码错误");
        }
        HashMap<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return ResponseResult.success(tokenMap);
    }
}
