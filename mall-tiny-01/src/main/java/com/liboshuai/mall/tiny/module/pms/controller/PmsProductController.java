package com.liboshuai.mall.tiny.module.pms.controller;


import com.alibaba.fastjson.JSONObject;
import com.liboshuai.mall.tiny.compone.response.ResponseResult;
import com.liboshuai.mall.tiny.module.pms.domain.dto.PmsBrandDTO;
import com.liboshuai.mall.tiny.module.pms.domain.dto.PmsProductAttributeValueES;
import com.liboshuai.mall.tiny.module.pms.domain.dto.PmsProductES;
import com.liboshuai.mall.tiny.module.pms.domain.req.AddProductReq;
import com.liboshuai.mall.tiny.module.pms.domain.req.EsSearchProduct;
import com.liboshuai.mall.tiny.module.pms.service.PmsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品信息 前端控制器
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Slf4j
@RestController
@RequestMapping("/mall.tiny.module.pms/pms-product")
@Api(tags = "商品", value = "PmsProductController")
public class PmsProductController {

    @Autowired
    private PmsProductService pmsProductService;

    @Resource
    private RestHighLevelClient restHighLevelClient;

    private static final String INDEX_NAME = "product";
    private static final String TYPE_NAME = "_doc";


    @ApiOperation(value = "导入全部商品到es中", httpMethod = "POST")
    @PostMapping("/importAllProductToEs")
    public ResponseResult<Boolean> importAllProductToEs() {
        boolean result = pmsProductService.importAllProductToEs();
        return ResponseResult.success(result);
    }

    @ApiOperation(value = "es精确查询", httpMethod = "POST")
    @PostMapping("/testTermQuery")
    public ResponseResult<List<PmsProductES>> testTermQuery() {
        List<PmsProductES> pmsProductESList = pmsProductService.testTermQuery();
        return ResponseResult.success(pmsProductESList);
    }

    @ApiOperation(value = "es查询全部数据", httpMethod = "POST")
    @PostMapping("/testMatchAllQuery")
    public ResponseResult<List<PmsProductES>> testMatchAllQuery() {
        List<PmsProductES> pmsProductESList = pmsProductService.testMatchAllQuery();
        return ResponseResult.success(pmsProductESList);
    }

    @ApiOperation(value = "es查询匹配数据", httpMethod = "POST")
    @PostMapping("/testMatchQuery")
    public ResponseResult<List<PmsProductES>> testMatchQuery(@RequestParam String name) {
        if (Objects.isNull(name)) {
            log.warn("入参不能为空");
            return ResponseResult.fail();
        }
        List<PmsProductES> pmsProductESList = pmsProductService.testMatchQuery(name);
        return ResponseResult.success(pmsProductESList);
    }


    @ApiOperation(value = "es词语匹配查询", httpMethod = "POST")
    @PostMapping("/testMatchPhraseQuery")
    public ResponseResult<List<PmsProductES>> testMatchPhraseQuery(@RequestParam String name) {
        return pmsProductService.testMatchPhraseQuery(name);
    }

    @ApiOperation(value = "es内容在多字段中进行查询", httpMethod = "POST")
    @PostMapping("/testMatchMultiQuery")
    public ResponseResult<List<PmsProductES>> testMatchMultiQuery(@RequestParam String query) {
        return pmsProductService.testMatchMultiQuery(query);
    }

    @ApiOperation(value = "es通配符查询", httpMethod = "POST")
    @PostMapping("/testWildcardQuery")
    public ResponseResult<List<PmsProductES>> testWildcardQuery(@RequestParam String name) {
        return pmsProductService.testWildcardQuery(name);
    }

    @ApiOperation(value = "es模糊查询", httpMethod = "POST")
    @PostMapping("/testFuzzQuery")
    public ResponseResult<List<PmsProductES>> testFuzzQuery(@RequestParam String name) {
        return pmsProductService.testFuzzQuery(name);
    }

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
                "        \"productAttributeValues\": {\n" +
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

    @ApiOperation(value = "获取索引映射结构", httpMethod = "POST")
    @PostMapping("/testGetIndexMapping")
    public ResponseResult<?> testGetIndexMapping() throws IOException {
        IndicesClient indicesClient = restHighLevelClient.indices();
        // 创建get请求
        GetIndexRequest request = new GetIndexRequest(INDEX_NAME);
        // 发送get请求
        GetIndexResponse response = indicesClient.get(request, RequestOptions.DEFAULT);
        // 获取索引映射结构
        Map<String, MappingMetaData> mappings = response.getMappings();
        log.info("获取索引映射结构: {}", JSONObject.toJSONString(mappings));
        return ResponseResult.success(JSONObject.toJSONString(mappings));
    }

    @ApiOperation(value = "判断索引是否存在", httpMethod = "POST")
    @PostMapping("/testIndexExists")
    public ResponseResult<?> testIndexExists() throws IOException {
        IndicesClient indicesClient = restHighLevelClient.indices();
        // 创建get请求
        GetIndexRequest request = new GetIndexRequest(INDEX_NAME);
        // 判断索引是否存在
        boolean result = indicesClient.exists(request, RequestOptions.DEFAULT);
        return ResponseResult.success(result);
    }

    @ApiOperation(value = "保存或更新一条文档", httpMethod = "POST")
    @PostMapping("/testSaveOrUpdateIndex")
    public ResponseResult<?> testSaveOrUpdateIndex() throws IOException {
        // 造假数据
        PmsProductAttributeValueES valueOneEs = PmsProductAttributeValueES.builder().productId(1L).productAttributeId(1L).value("牛奶王one").build();
        PmsProductAttributeValueES valueTwoEs = PmsProductAttributeValueES.builder().productId(2L).productAttributeId(2L).value("牛奶王two").build();
        PmsProductES pmsProductES = PmsProductES.builder()
                .id(1L)
                .name("特仑苏")
                .keywords("纯牛奶")
                .brandName("蒙牛")
                .productCategoryName("乳制品")
                .subTitle("不是所有牛奶都叫特仑苏")
                .productAttributeValues(Arrays.asList(valueOneEs, valueTwoEs))
                .createTime("2022-10-10")
                .updateTime("2022-10-10")
                .build();
        // 创建索引请求对象
        IndexRequest indexRequest = new IndexRequest(INDEX_NAME, TYPE_NAME).id(pmsProductES.getId().toString()).source(JSONObject.toJSONString(pmsProductES), XContentType.JSON);
        // 执行增加文档
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        return ResponseResult.success(indexResponse.status());
    }

    @ApiOperation(value = "根据id查询文档数据", httpMethod = "POST")
    @PostMapping("/testGetDocument")
    public ResponseResult<?> testGetDocument() throws IOException {
        // 创建获取请求对象
        GetRequest getRequest = new GetRequest(INDEX_NAME);
        getRequest.id("1");
        GetResponse response = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        return ResponseResult.success(response.getSourceAsString());
    }

    @ApiOperation(value = "根据id更新文档数据", httpMethod = "POST")
    @PostMapping("/testUpdateDocument")
    public ResponseResult<?> testUpdateDocument() throws IOException {
        // 造假数据
        PmsProductAttributeValueES valueOneEs = PmsProductAttributeValueES.builder().productId(1L).productAttributeId(1L).value("牛奶王one").build();
        PmsProductAttributeValueES valueTwoEs = PmsProductAttributeValueES.builder().productId(2L).productAttributeId(2L).value("牛奶王two").build();
        PmsProductES pmsProductES = PmsProductES.builder()
                .id(1L)
                .name("特仑苏")
                .keywords("纯牛奶")
                .brandName("蒙牛")
                .productCategoryName("乳制品")
                .subTitle("不是所有牛奶都叫特仑苏")
                .productAttributeValues(Arrays.asList(valueOneEs, valueTwoEs))
                .createTime("2022-10-12")
                .updateTime("2022-10-14")
                .build();
        // 创建索引请求对象
        UpdateRequest updateRequest = new UpdateRequest(INDEX_NAME, TYPE_NAME, pmsProductES.getId().toString());
        // 设置更新文档内容
        updateRequest.doc(JSONObject.toJSONString(pmsProductES), XContentType.JSON);
        // 执行更新文档
        UpdateResponse response = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        return ResponseResult.success(response.status());
    }

    @ApiOperation(value = "根据id删除文档", httpMethod = "POST")
    @PostMapping("/testDeleteDocument")
    public ResponseResult<?> testDeleteDocument() throws IOException {
        // 创建删除请求对象
        DeleteRequest deleteRequest = new DeleteRequest(INDEX_NAME, TYPE_NAME, "1");
        // 执行删除文档
        DeleteResponse response = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        return ResponseResult.success(response.status());
    }
}
