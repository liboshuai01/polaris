package com.liboshuai.mall.tiny.controller;

import com.liboshuai.mall.tiny.domain.dao.UmsAdmin;
import com.liboshuai.mall.tiny.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2022-07-10 20:35
 * @Description: 请求返回码
 */
@RestController
@Slf4j
@NoArgsConstructor
@Api(tags = "用户管理")
@RequestMapping(value = "/umsAdmin")
public class UmsAdminController {

    private UmsAdminService umsAdminService;

    @Autowired
    public UmsAdminController(UmsAdminService umsAdminService) {
        this.umsAdminService = umsAdminService;
    }

    @ApiOperation(value = "查询指定名称的用户", httpMethod = "GET")
    @GetMapping("/findAllByUsername/{username}")
    public UmsAdmin findAllByUsername(@PathVariable String username) {
        return umsAdminService.findAllByUsername(username);
    }
}
