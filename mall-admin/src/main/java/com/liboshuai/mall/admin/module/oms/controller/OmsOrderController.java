package com.liboshuai.mall.admin.module.oms.controller;


import com.liboshuai.mall.admin.compone.response.ResponseResult;
import com.liboshuai.mall.admin.module.oms.domain.req.GenerateOrderReq;
import com.liboshuai.mall.admin.module.oms.service.OmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@RestController
@RequestMapping("/mall.tiny.module.oms/oms-order")
@Api(tags = "订单管理", value = "OmsOrderController")
public class OmsOrderController {
    @Autowired
    private OmsOrderService omsOrderService;

    @ApiOperation(value = "根据购物车信息生成订单", httpMethod = "POST")
    @PostMapping(value = "/generateOrder")
    public ResponseResult<?> generateOrder(@RequestBody GenerateOrderReq generateOrderReq) {
        return omsOrderService.generateOrder(generateOrderReq);
    }
}
