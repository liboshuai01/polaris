package com.liboshuai.mall.tiny.controller;


import com.liboshuai.mall.tiny.common.api.CommonResult;
import com.liboshuai.mall.tiny.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Api(tags = "会员登录注册管理", value = "UmsMemberController")
@RestController
@RequestMapping("/mall.tiny/ums-member")
@Slf4j
public class UmsMemberController {

    private final UmsMemberService umsMemberService;

    @Autowired
    public UmsMemberController(UmsMemberService umsMemberService) {
        this.umsMemberService = umsMemberService;
    }

    @ApiOperation(value = "获取验证码", httpMethod = "GET")
    @GetMapping(value = "/getAuthCode")
    public CommonResult getAuthCode(@RequestParam String telephone) {
        log.info("------开始获取验证码------");
        return umsMemberService.generateAuthCode(telephone);
    }

    @ApiOperation(value = "判断验证码是否正确", httpMethod = "POST")
    @PostMapping(value = "/verifyAuthCode")
    public CommonResult verifyAuthCode(@RequestParam String telephone, @RequestParam String authCode) {
        return umsMemberService.verifyAuthCode(telephone, authCode);
    }
}
