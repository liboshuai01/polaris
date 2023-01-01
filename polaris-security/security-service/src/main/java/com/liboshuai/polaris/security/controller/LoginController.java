package com.liboshuai.polaris.security.controller;

import com.alibaba.fastjson.JSONObject;
import com.liboshuai.polaris.common.domain.ResponseResult;
import com.liboshuai.polaris.security.query.LoginQuery;
import com.liboshuai.polaris.security.vo.Oauth2TokenVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseResult<Oauth2TokenVO> login(@RequestBody LoginQuery loginQuery) {
        log.info("-------用户{}进行登录操作-------", JSONObject.toJSONString(loginQuery));
        Oauth2TokenVO oauth2TokenVO = Oauth2TokenVO.builder().token("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImNyZWF0ZWQiOjE2NzI1OTYxMTgzMjMsImV4cCI6MTY3MzIwMDkxOH0.kE8z08Sb6vS1-z-3RGFHhxrm1PXUaG3ozf65RgR83Jcp9zKV5bl0gIKAE65qWxr1SWRMOI96r5wOqxpjR-ZRVA")
                .tokenHead("Bearer ")
                .build();
        return ResponseResult.success("登录成功", oauth2TokenVO);
    }

}
