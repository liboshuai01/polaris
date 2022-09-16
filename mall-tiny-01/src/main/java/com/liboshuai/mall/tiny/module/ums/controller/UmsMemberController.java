package com.liboshuai.mall.tiny.module.ums.controller;


import com.liboshuai.mall.tiny.compone.response.ResponseResult;
import com.liboshuai.mall.tiny.module.ums.service.UmsMemberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@RestController
@RequestMapping("/mall.tiny.module.ums/ums-member")
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
