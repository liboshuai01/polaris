package com.liboshuai.mall.tiny.module.pms.controller;


import com.alibaba.fastjson.JSONObject;
import com.liboshuai.mall.tiny.compone.response.ResponseResult;
import com.liboshuai.mall.tiny.module.pms.domain.req.AddProductReq;
import com.liboshuai.mall.tiny.module.pms.domain.req.EsSearchProduct;
import com.liboshuai.mall.tiny.module.pms.service.PmsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
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
@Slf4j
@RestController
@RequestMapping("/mall.tiny.module.pms/pms-product")
public class PmsProductController {

    @Autowired
    private PmsProductService pmsProductService;

    @Resource
    private RestHighLevelClient restHighLevelClient;

    private static final String INDEX_NAME = "product";

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

    @ApiOperation(value = "创建索引和映射", httpMethod = "POST")
    @PostMapping("/testCreateIndexAndMapping")
    public ResponseResult<?> testCreateIndexAndMapping() throws IOException {
        //参数 1: 创建索引请求对象  参数 2: 请求配置对象
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(INDEX_NAME);
        //指定映射 参数 1: 指定映射 json 结构  参数 2:指定数据类型
        createIndexRequest.mapping("{\n" +
                "    \"properties\": {\n" +
                "        \"brandName\": {\n" +
                "            \"type\": \"keyword\"\n" +
                "        },\n" +
                "        \"createTime\": {\n" +
                "            \"type\": \"date\"\n" +
                "        },\n" +
                "        \"id\": {\n" +
                "            \"type\": \"long\"\n" +
                "        },\n" +
                "        \"keywords\": {\n" +
                "            \"type\": \"text\",\n" +
                "            \"analyzer\": \"ik_max_word\"\n" +
                "        },\n" +
                "        \"name\": {\n" +
                "            \"type\": \"text\",\n" +
                "            \"analyzer\": \"ik_max_word\"\n" +
                "        },\n" +
                "        \"productAttributeValue\": {\n" +
                "            \"type\": \"nested\",\n" +
                "            \"properties\": {\n" +
                "                \"productAttributeId\": {\n" +
                "                    \"type\": \"long\"\n" +
                "                },\n" +
                "                \"productId\": {\n" +
                "                    \"type\": \"long\"\n" +
                "                },\n" +
                "                \"value\": {\n" +
                "                    \"type\": \"keyword\"\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        \"productCategoryName\": {\n" +
                "            \"type\": \"keyword\"\n" +
                "        },\n" +
                "        \"subTitle\": {\n" +
                "            \"type\": \"text\",\n" +
                "            \"analyzer\": \"ik_max_word\"\n" +
                "        },\n" +
                "        \"updateTime\": {\n" +
                "            \"type\": \"date\"\n" +
                "        }\n" +
                "    }\n" +
                "}", XContentType.JSON);
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        log.info("创建状态: {}", createIndexResponse.isAcknowledged());
        // 关闭资源
        restHighLevelClient.close();
        return ResponseResult.success();
    }

    @ApiOperation(value = "删除索引", httpMethod = "POST")
    @PostMapping("/testDeleteIndex")
    public ResponseResult<?> testDeleteIndex() throws IOException {
        IndicesClient indices = restHighLevelClient.indices();
        // 创建delete请求方式
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(INDEX_NAME);
        AcknowledgedResponse delete = indices.delete(deleteIndexRequest, RequestOptions.DEFAULT);
        if (delete.isAcknowledged()) {
            return ResponseResult.success();
        }
        return ResponseResult.fail();
    }

    @ApiOperation(value = "保存或更新一条文档", httpMethod = "POST")
    @PostMapping("/testSaveOrUpdateIndex")
    public ResponseResult<?> testSaveOrUpdateIndex() throws IOException {


        BulkRequest bulkRequest = new BulkRequest();
//        bulkRequest.add(new IndexRequest(INDEX_NAME).source(JSONObject.toJSONString()))
        return ResponseResult.success();
    }

}
