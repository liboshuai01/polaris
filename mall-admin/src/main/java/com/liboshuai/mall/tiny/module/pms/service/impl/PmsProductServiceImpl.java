package com.liboshuai.mall.tiny.module.pms.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.mall.tiny.common.constants.DatePattern;
import com.liboshuai.mall.tiny.compone.response.ResponseResult;
import com.liboshuai.mall.tiny.module.pms.domain.dto.PmsBrandDTO;
import com.liboshuai.mall.tiny.module.pms.domain.dto.PmsProductAttributeValueES;
import com.liboshuai.mall.tiny.module.pms.domain.dto.PmsProductES;
import com.liboshuai.mall.tiny.module.pms.domain.entity.PmsProduct;
import com.liboshuai.mall.tiny.module.pms.domain.entity.PmsProductAttributeValue;
import com.liboshuai.mall.tiny.module.pms.domain.req.AddProductReq;
import com.liboshuai.mall.tiny.module.pms.domain.req.EsSearchProduct;
import com.liboshuai.mall.tiny.module.pms.mapper.PmsProductMapper;
import com.liboshuai.mall.tiny.module.pms.service.PmsProductAttributeValueService;
import com.liboshuai.mall.tiny.module.pms.service.PmsProductService;
import com.liboshuai.mall.tiny.utils.DateUtil;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.ClearScrollRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Service
public class PmsProductServiceImpl extends ServiceImpl<PmsProductMapper, PmsProduct> implements PmsProductService {

    @Autowired
    private PmsProductMapper pmsProductMapper;

    @Autowired
    private PmsProductAttributeValueService pmsProductAttributeValueService;

    @Resource
    private RestHighLevelClient restHighLevelClient;

    private static final String INDEX_NAME = "product";
    private static final String TYPE_NAME = "_doc";

    /**
     * 从数据库中导入所有商品到ES
     */
    @Override
    public boolean importAllProductToEs() {
        // 查询全部product
        List<PmsProductES> esProductList = getPmsProductES();
        if (esProductList == null) {return true;}
        // 创建批量请求
        BulkRequest bulkRequest = new BulkRequest();
        // 创建IndexRequest添加数据
        esProductList.forEach(esProduct -> {
            IndexRequest indexRequest = new IndexRequest(INDEX_NAME, TYPE_NAME);
            indexRequest.id(esProduct.getId().toString()).source(JSONObject.toJSONString(esProduct), XContentType.JSON);
            bulkRequest.add(indexRequest);
        });
        try {
            BulkResponse response = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            return Objects.equals(response.status(), RestStatus.OK);
        } catch (IOException ioException) {
            log.error("从数据库中导入所有商品到ES失败: {}", ioException);
            return false;
        }
    }

    /**
     * es精确查询测试
     */
    @Override
    public List<PmsProductES> testTermQuery() {
        // 构建查询条件（注意：termQuery 支持多种格式查询，如 boolean、int、double、string 等，这里使用的是 string 的查询）
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termsQuery("brandName", "小米", "红米"));
        // 展示100条, 默认只展示10条记录
        searchSourceBuilder.size(100);
        // 创建查询请求对象, 将查询对象配置到其中
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        searchRequest.source(searchSourceBuilder);
        // 执行查询, 然后处理响应结果
        SearchResponse searchResponse;
        try {
            searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException ioException) {
            log.error("es精确查询测试异常: {}", ioException);
            return null;
        }
        // 根据状态和数据条数验证是否返回了数据
        List<PmsProductES> pmsBrandDTOList = new ArrayList<>();
        if (Objects.equals(searchResponse.status(), RestStatus.OK)) {
            SearchHits hits = searchResponse.getHits();
            hits.forEach(hit -> pmsBrandDTOList.add(JSONObject.parseObject(hit.getSourceAsString(), PmsProductES.class)));
            return pmsBrandDTOList;
        }
        return null;
    }

    /**
     * es查询全部数据
     */
    @Override
    public List<PmsProductES> testMatchAllQuery() {
        // 构建查询条件
        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        // 创建查询源构造器
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(matchAllQueryBuilder);
        // 设置分页
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(3);
        // 设置排序
        searchSourceBuilder.sort("createTime", SortOrder.DESC);
        // 创建查询请求对象, 将查询对象配置到其中
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        searchRequest.source(searchSourceBuilder);
        // 执行查询, 然后处理响应结果
        SearchResponse searchResponse = null;
        try {
            searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException ioException) {
            log.error("es查询全部数据异常:{}", ioException);
        }
        // 根据状态验证是否返回了数据
        if (Objects.equals(searchResponse.status(), RestStatus.OK)) {
            SearchHits hits = searchResponse.getHits();
            List<PmsProductES> pmsProductESList = new ArrayList<>();
            hits.forEach(hit -> {
                pmsProductESList.add(JSONObject.parseObject(hit.getSourceAsString(), PmsProductES.class));
            });
            return pmsProductESList;
        }
        return null;
    }

    /**
     * es查询匹配数据
     */
    @Override
    public List<PmsProductES> testMatchQuery(String name) {
        // 构建查询条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("name", name));
        // 创建查询请求对象, 将查询对象配置到其中
        SearchRequest searchRequest = new SearchRequest(TYPE_NAME);
        searchRequest.source(searchSourceBuilder);
        // 执行查询, 然后处理响应结果
        SearchResponse searchResponse = null;
        try {
            searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException ioException) {
            log.error("es查询匹配数据异常: ", ioException);
            return null;
        }
        // 根据状态验证是否返回了数据
        if (Objects.equals(searchResponse.status(), RestStatus.OK)) {
            SearchHits hits = searchResponse.getHits();
            ArrayList<PmsProductES> pmsProductES = new ArrayList<>();
            hits.forEach(hit -> pmsProductES.add(JSONObject.parseObject(hit.getSourceAsString(), PmsProductES.class)));
            return pmsProductES;
        }
        return null;
    }

    /**
     * es词语匹配查询
     */
    @Override
    public ResponseResult<List<PmsProductES>> testMatchPhraseQuery(String name) {
        // 构建查询条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchPhraseQuery("name", name));
        // 创建查询请求对象, 将查询对象配置到其中
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        searchRequest.source(searchSourceBuilder);
        // 执行查询, 然后处理响应结果
        SearchResponse searchResponse;
        try {
            searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("es词语匹配查询: ", e);
            return ResponseResult.fail();
        }
        if (Objects.equals(searchResponse.status(), RestStatus.OK)) {
            SearchHits hits = searchResponse.getHits();
            ArrayList<PmsProductES> pmsProductES = new ArrayList<>();
            hits.forEach(hit -> pmsProductES.add(JSONObject.parseObject(hit.getSourceAsString(), PmsProductES.class)));
            return ResponseResult.success(pmsProductES);
        }
        return ResponseResult.fail();
    }

    /**
     * es内容在多字段中进行查询
     */
    @Override
    public ResponseResult<List<PmsProductES>> testMatchMultiQuery(String query) {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.multiMatchQuery(query, "name", "subTitle"));
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse;
        try {
            searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("es内容在多字段中进行查询: ", e);
            return ResponseResult.fail();
        }
        if (Objects.equals(searchResponse.status(), RestStatus.OK)) {
            SearchHits hits = searchResponse.getHits();
            ArrayList<PmsProductES> pmsProductES = new ArrayList<>();
            hits.forEach(hit -> pmsProductES.add(JSONObject.parseObject(hit.getSourceAsString(), PmsProductES.class)));
            return ResponseResult.success(pmsProductES);
        }
        return ResponseResult.fail();
    }

    /**
     * es通配符查询
     */
    @Override
    public ResponseResult<List<PmsProductES>> testWildcardQuery(String name) {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.wildcardQuery("name", name));
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse;
        try {
            searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("es通配符查询: ", e);
            return ResponseResult.fail();
        }
        if (Objects.equals(searchResponse.status(), RestStatus.OK)) {
            SearchHits hits = searchResponse.getHits();
            ArrayList<PmsProductES> pmsProductES = new ArrayList<>();
            hits.forEach(hit -> pmsProductES.add(JSONObject.parseObject(hit.getSourceAsString(), PmsProductES.class)));
            return ResponseResult.success(pmsProductES);
        }
        return ResponseResult.fail();
    }

    /**
     * es模糊查询
     */
    @Override
    public ResponseResult<List<PmsProductES>> testFuzzQuery(String subTitle) {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.fuzzyQuery("subTitle", subTitle).fuzziness(Fuzziness.AUTO));
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse;
        try {
            searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("es模糊查询: ", e);
            return ResponseResult.fail();
        }
        if (Objects.equals(searchResponse.status(), RestStatus.OK)) {
            SearchHits hits = searchResponse.getHits();
            ArrayList<PmsProductES> pmsProductES = new ArrayList<>();
            hits.forEach(hit -> pmsProductES.add(JSONObject.parseObject(hit.getSourceAsString(), PmsProductES.class)));
            return ResponseResult.success(pmsProductES);
        }
        return ResponseResult.fail();
    }

    /**
     * es分页查询
     */
    @Override
    public ResponseResult<List<PmsProductES>> testPageQuery(int pageNum, int pageSize) {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        // 设置分页
        searchSourceBuilder.from(pageNum);
        searchSourceBuilder.size(pageSize);
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse;
        try {
            searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("es分页查询: ", e);
            return ResponseResult.fail();
        }
        if (Objects.equals(searchResponse.status(), RestStatus.OK)) {
            SearchHits hits = searchResponse.getHits();
            ArrayList<PmsProductES> pmsProductES = new ArrayList<>();
            hits.forEach(hit -> pmsProductES.add(JSONObject.parseObject(hit.getSourceAsString(), PmsProductES.class)));
            return ResponseResult.success(pmsProductES);
        }
        return ResponseResult.fail();
    }

    /**
     * es排序查询
     */
    @Override
    public ResponseResult<List<PmsProductES>> testSortQuery() {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchSourceBuilder.sort("createTime", SortOrder.DESC);
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse;
        try {
            searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("es排序查询: ", e);
            return ResponseResult.fail();
        }
        if (Objects.equals(searchResponse.status(), RestStatus.OK)) {
            SearchHits hits = searchResponse.getHits();
            ArrayList<PmsProductES> pmsProductES = new ArrayList<>();
            hits.forEach(hit -> pmsProductES.add(JSONObject.parseObject(hit.getSourceAsString(), PmsProductES.class)));
            return ResponseResult.success(pmsProductES);
        }
        return ResponseResult.fail();
    }

    /**
     * es滚动查询
     */
    @Override
    public ResponseResult<List<PmsProductES>> testScrollQuery(int pageNum, int pageSize) {
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery()).size(pageSize);
        String scrollId = null;
        SearchResponse scrollResponse = null;
        Scroll scroll = new Scroll(TimeValue.timeValueMinutes(2));
        ArrayList<String> scrollIds = new ArrayList<>();
        for (int i = 0; i < pageNum; i++) {
            if (i == 0) {
                searchRequest.scroll(scroll);
                SearchResponse response = null;
                try {
                    response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
                } catch (IOException e) {
                    log.error("es滚动查询: ", e);
                    return ResponseResult.fail(e.getMessage());
                }
                scrollId = response.getScrollId();
            }else {
                // 不需要在使用其他条件，也不需要指定索引名称，只需要使用执行游标id存活时间和上次游标id即可，毕竟信息都在上次游标id里面呢
                SearchScrollRequest searchScrollRequest = new SearchScrollRequest(scrollId);
                searchScrollRequest.scroll(scroll);
                try {
                    scrollResponse = restHighLevelClient.scroll(searchScrollRequest, RequestOptions.DEFAULT);
                } catch (IOException e) {
                    log.error("es滚动查询: ", e);
                    return ResponseResult.fail(e.getMessage());
                }
                scrollId = scrollResponse.getScrollId();
            }
            scrollIds.add(scrollId);
        }
        ClearScrollRequest clearScrollRequest = new ClearScrollRequest();
        clearScrollRequest.scrollIds(scrollIds);
        try {
            restHighLevelClient.clearScroll(clearScrollRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("清除滚动查询游标id失败: ", e);
            return ResponseResult.fail();
        }
        SearchHits hits = null;
        if (scrollResponse != null) {
            hits = scrollResponse.getHits();
        }
        ArrayList<PmsProductES> pmsProductES = new ArrayList<>();
        if (hits != null) {
            hits.forEach(hit -> pmsProductES.add(JSONObject.parseObject(hit.getSourceAsString(), PmsProductES.class)));
        }
        return ResponseResult.success(pmsProductES);
    }

    /**
     * es范围查询
     */
    @Override
    public ResponseResult<List<PmsProductES>> testRangeQuery() {
        // 构建查询条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.rangeQuery("createTime").gte("2022-12-01"));
        // 创建查询请求对象，将查询对象配置到其中
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        searchRequest.source(searchSourceBuilder);
        // 执行查询，然后处理响应结果
        SearchResponse searchResponse;
        try {
            searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("es范围查询: ", e);
            return ResponseResult.fail();
        }
        // 根据状态判断是否返回了数据
        if (Objects.equals(searchResponse.status(), RestStatus.OK)) {
            SearchHits hits = searchResponse.getHits();
            ArrayList<PmsProductES> pmsProductES = new ArrayList<>();
            hits.forEach(hit -> pmsProductES.add(JSONObject.parseObject(hit.getSourceAsString(), PmsProductES.class)));
            return ResponseResult.success(pmsProductES);
        }
        return ResponseResult.fail();
    }

    /**
     * es布尔查询
     */
    @Override
    public ResponseResult<List<PmsProductES>> testBoolQuery() {
        // 创建 Bool 查询构建器
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        // 构建查询条件
        boolQueryBuilder.must(QueryBuilders.matchQuery("name", "小米")).filter().add(QueryBuilders.rangeQuery("createTime").gte("2022-12-01"));
        // 构建查询源构建器
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(boolQueryBuilder);
        // 创建查询请求对象，将查询对象配置到其中
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        searchRequest.source(searchSourceBuilder);
        // 执行查询，然后处理响应结果
        SearchResponse searchResponse;
        try {
            searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("es范围查询: ", e);
            return ResponseResult.fail();
        }
        // 根据状态判断是否返回了数据
        if (Objects.equals(searchResponse.status(), RestStatus.OK)) {
            SearchHits hits = searchResponse.getHits();
            ArrayList<PmsProductES> pmsProductES = new ArrayList<>();
            hits.forEach(hit -> pmsProductES.add(JSONObject.parseObject(hit.getSourceAsString(), PmsProductES.class)));
            return ResponseResult.success(pmsProductES);
        }
        return ResponseResult.fail();
    }

    private List<PmsProductES> getPmsProductES() {
        List<PmsProduct> pmsProductList = this.list();
        if (CollectionUtils.isEmpty(pmsProductList)) {
            log.warn("从数据库中导入所有商品到ES-查询全部product为空");
            return null;
        }
        List<PmsProductES> esProductList = pmsProductList.stream().filter(Objects::nonNull).map(product -> {
            PmsProductES esProduct = new PmsProductES();
            BeanUtils.copyProperties(product, esProduct);
            esProduct.setCreateTime(Objects.isNull(product.getCreateTime()) ? null
                    : DateUtil.date2String(product.getCreateTime(), DatePattern.NORM_DATE_PATTERN));
            esProduct.setUpdateTime(Objects.isNull(product.getUpdateTime()) ? null
                    : DateUtil.date2String(product.getUpdateTime(), DatePattern.NORM_DATE_PATTERN));
            return esProduct;
        }).collect(Collectors.toList());
        // 拿到所有product的id集合
        List<Long> pmsProductIdList = pmsProductList.stream().map(PmsProduct::getId).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(pmsProductIdList)) {
            log.warn("从数据库中导入所有商品到ES-所有product的id集合为空");
            return null;
        }
        // 根据productId集合查询PmsProductAttributeValue集合
        List<PmsProductAttributeValue> pmsProductAttributeValues = pmsProductAttributeValueService.lambdaQuery()
                .in(PmsProductAttributeValue::getProductId, pmsProductIdList).list();
        // 拿到查询到的PmsProductAttributeValue集合, 然后根据ProductId进行分组
        Map<Long, List<PmsProductAttributeValue>> productIdAndProductValueMap = pmsProductAttributeValues.stream()
                .collect(Collectors.groupingBy(PmsProductAttributeValue::getProductId));
        // 遍历设置Product集合中的attrValueList属性
        for (Map.Entry<Long, List<PmsProductAttributeValue>> entry :
                productIdAndProductValueMap.entrySet()) {
            esProductList = esProductList.stream().peek(esProduct -> {
                if (Objects.equals(esProduct.getId(), entry.getKey())) {
                    List<PmsProductAttributeValueES> esProductAttributeValues = entry.getValue().stream()
                            .map(pmsProductAttributeValue -> {
                                PmsProductAttributeValueES esProductAttributeValue = new PmsProductAttributeValueES();
                                BeanUtils.copyProperties(pmsProductAttributeValue, esProductAttributeValue);
                                return esProductAttributeValue;
                            }).collect(Collectors.toList());
                    esProduct.setProductAttributeValues(esProductAttributeValues);
                }
            }).collect(Collectors.toList());
        }
        return esProductList;
    }

    /**
     * 根据id删除es中的商品
     *
     * @param id 成功删除的商品数量
     */
//    @Override
//    public void deleteEsProductById(Long id) {
//        restHighLevelClient.deleteById(id);
//    }

    /**
     * 批量添加商品信息
     */
//    @Override
//    public int addProduct(List<AddProductReq> addProductReqs) {
//        List<PmsProduct> pmsProductList = addProductReqs.stream().map(addProductReq -> {
//            PmsProduct pmsProduct = new PmsProduct();
//            BeanUtils.copyProperties(addProductReq, pmsProduct);
//            if (!StringUtils.isEmpty(addProductReq.getPrice())) {
//                pmsProduct.setPrice(new BigDecimal(addProductReq.getPrice()));
//            }
//            return pmsProduct;
//        }).collect(Collectors.toList());
//        return pmsProductMapper.insertBatch(pmsProductList);
//    }

    /**
     * 根据商品名称,商品副标题,商品关键字分页搜索商品信息
     */
//    @Override
//    public Page<EsProduct> esProductSearch(EsSearchProduct esSearchProduct) {
//        if (Objects.isNull(esSearchProduct)) {
//            return null;
//        }
//        PageRequest pageRequest = PageRequest.of(esSearchProduct.getPageNum(), esSearchProduct.getPageSize());
//        return restHighLevelClient.findByNameOrSubTitleOrKeywords(esSearchProduct.getName(), esSearchProduct.getSubTitle(), esSearchProduct.getKeywords(), pageRequest);
//    }
}
