package com.liboshuai.polaris.oms.service.controller;

import com.liboshuai.polaris.common.domain.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/1 03:45
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("order")
@Api(tags = "订单", value = "OmsOrderController")
public class OmsOrderController {

    @ApiOperation(value = "hello", httpMethod = "POST")
    @PostMapping("/hello")
    public ResponseResult<?> register() {
        log.info("------------hello world------------");
        return ResponseResult.success("hello world!");
    }
}
