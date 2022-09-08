package com.liboshuai.mall.tiny.module.ums.controller;


import com.liboshuai.mall.tiny.common.api.ResponseCode;
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
@Api(tags = "后台用户管理", value = "UmsAdminController")
@RestController
@RequestMapping("/ums/admin")
@Slf4j
public class UmsAdminController {

    @Autowired
    private UmsAdminService umsAdminService;


    @ApiOperation(value = "根据会员名称查询用户id", httpMethod = "GET")
    @GetMapping("/findUserIdByUserName")
    public ResponseResult<Long> findUserIdByUserName(@RequestParam String userName) {
        Long userId = umsAdminService.findUserIdByUserName(userName);
        return ResponseResult.success(userId);
    }

}
