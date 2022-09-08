package com.liboshuai.mall.tiny.module.ums.controller;


import com.liboshuai.mall.tiny.common.api.ResponseResult;
import com.liboshuai.mall.tiny.module.ums.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Api(tags = "会员管理", value = "UmsMemberController")
@RestController
@RequestMapping("/ums/member")
@Slf4j
public class UmsMemberController {

    @Autowired
    private UmsMemberService umsMemberService;

    @ApiOperation(value = "获取验证码", httpMethod = "GET")
    @GetMapping(value = "/getAuthCode")
    public ResponseResult<String> getAuthCode(@RequestParam String telephone) {
        return umsMemberService.generateAuthCode(telephone);
    }

    @ApiOperation(value = "判断验证码是否正确", httpMethod = "POST")
    @PostMapping(value = "/verifyAuthCode")
    public ResponseResult<?>  verifyAuthCode(@RequestParam String telephone, @RequestParam String authCode) {
        return umsMemberService.verifyAuthCode(telephone, authCode);
    }
}
