package com.liboshuai.mall.tiny.module.pms.controller;


import com.liboshuai.mall.tiny.compone.response.ResponseResult;
import com.liboshuai.mall.tiny.module.pms.domain.req.ProductSaveOrUpdateReq;
import com.liboshuai.mall.tiny.module.pms.service.PmsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品信息 前端控制器
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Api(tags = "商品", value = "PmsProductController")
@RestController
@RequestMapping("/mall.tiny.module.pms/pms-product")
public class PmsProductController {

    @Autowired
    private PmsProductService pmsProductService;

    @ApiOperation(value = "导入全部商品到es中", httpMethod = "POST")
    @PostMapping("/importAllProductToEs")
    public ResponseResult<Integer> importAllProductToEs() {
        int result = pmsProductService.importAllProductToEs();
        return ResponseResult.success(result);
    }

    @ApiOperation(value = "根据id删除es中的商品", httpMethod = "POST")
    @PostMapping("/deleteEsProductById")
    public ResponseResult<?> deleteEsProductById(@RequestParam Long id) {
        pmsProductService.deleteEsProductById(id);
        return ResponseResult.success();
    }

    @ApiOperation(value = "批量添加商品信息", httpMethod = "POST")
    @PostMapping("/addProduct")
    public ResponseResult<?> addProduct(@RequestBody List<ProductSaveOrUpdateReq> productSaveOrUpdateReqs) {
        int result = pmsProductService.addProduct(productSaveOrUpdateReqs);
        if (result == 1) {
            return ResponseResult.success();
        } else {
            return ResponseResult.fail();
        }
    }

}
