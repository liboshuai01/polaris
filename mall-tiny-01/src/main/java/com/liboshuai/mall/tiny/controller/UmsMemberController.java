package com.liboshuai.mall.tiny.controller;

import com.liboshuai.mall.tiny.common.api.CommonResult;
import com.liboshuai.mall.tiny.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: liboshuai
 * @Date: 2022-07-21 14:46
 * @Description: 会员登录注册管理
 */
@RestController
@Api(tags = "会员登录注册管理")
@RequestMapping("/sso")
public class UmsMemberController {

    @Autowired
    private UmsMemberService umsMemberService;

    @ApiOperation(value = "获取验证码", httpMethod = "GET")
    @GetMapping("/getAuthCode")
    public CommonResult<String> getAuthCode(@RequestParam String telephone) {
        return umsMemberService.generateAuthCode(telephone);
    }

    @ApiOperation(value = "判断验证码是否正确", httpMethod = "POST")
    @PostMapping("/verifyAuthCode")
    public CommonResult<Object> verifyAuthCode(@RequestParam String telephone, @RequestParam String authCode) {
        return umsMemberService.verifyAuthCode(telephone, authCode);
    }
}
