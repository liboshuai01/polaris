package com.liboshuai.mall.tiny.module.pms.controller;


import com.liboshuai.mall.tiny.compone.response.ResponseResult;
import com.liboshuai.mall.tiny.module.pms.domain.req.AddProductReq;
import com.liboshuai.mall.tiny.module.pms.domain.req.EsSearchProduct;
import com.liboshuai.mall.tiny.module.pms.service.PmsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    /**
     * 创建商品es索引和类型
     */
//    @ApiOperation(value = "创建商品es索引和类型", httpMethod = "POST")
//    @PostMapping("/createEsIndexType")
//    public ResponseResult<Integer> createEsIndexType() {
//        pmsProductService.createEsIndexType();
//        return ResponseResult.success();
//    }

//    @ApiOperation(value = "导入全部商品到es中", httpMethod = "POST")
//    @PostMapping("/importAllProductToEs")
//    public ResponseResult<Integer> importAllProductToEs() {
//        int result = pmsProductService.importAllProductToEs();
//        return ResponseResult.success(result);
//    }
//
//    @ApiOperation(value = "根据id删除es中的商品", httpMethod = "POST")
//    @PostMapping("/deleteEsProductById")
//    public ResponseResult<?> deleteEsProductById(@RequestParam Long id) {
//        pmsProductService.deleteEsProductById(id);
//        return ResponseResult.success();
//    }
//
//    @ApiOperation(value = "批量添加商品信息", httpMethod = "POST")
//    @PostMapping("/addProduct")
//    public ResponseResult<?> addProduct(@RequestBody List<AddProductReq> addProductReqs) {
//        if (CollectionUtils.isEmpty(addProductReqs)) {
//            return ResponseResult.fail();
//        }
//        addProductReqs = addProductReqs.stream().filter(Objects::nonNull).collect(Collectors.toList());
//        int result = pmsProductService.addProduct(addProductReqs);
//        if (result == addProductReqs.size()) {
//            return ResponseResult.success();
//        } else {
//            return ResponseResult.fail();
//        }
//    }

//    @ApiOperation(value = "es搜索商品", httpMethod = "POST")
//    @PostMapping("/esProductSearch")
//    public ResponseResult<?> esProductSearch(@RequestBody EsSearchProduct esSearchProduct) {
//        Page<EsProduct> esProducts = pmsProductService.esProductSearch(esSearchProduct);
//        return ResponseResult.success(esProducts);
//    }

}
