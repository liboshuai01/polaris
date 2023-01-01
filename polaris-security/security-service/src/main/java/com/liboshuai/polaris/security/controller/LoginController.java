package com.liboshuai.polaris.security.controller;

import com.alibaba.fastjson.JSONObject;
import com.liboshuai.polaris.common.domain.ResponseResult;
import com.liboshuai.polaris.security.query.LoginQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 00:06
 * @Description: 登录相关功能
 */
@Slf4j
@RestController
@Api(tags = "登录相关功能", value = "LoginController")
public class LoginController {

    @ApiOperation(value = "登录", httpMethod = "POST")
    @PostMapping("/login")
    public ResponseResult<?> login(@RequestBody LoginQuery loginQuery) {
        log.info("-------用户{}进行登录操作-------", JSONObject.toJSONString(loginQuery));
        return ResponseResult.success("登录成功");
    }

}
