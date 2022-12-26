package com.liboshuai.mall.tiny.module.oms.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 购物车表 前端控制器
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@RestController
@Slf4j
@RequestMapping("/mall.tiny.module.oms/oms-cart-item")
public class OmsCartItemController {

    public void test() {
        log.debug("这是我的测试代码");
    }

}
