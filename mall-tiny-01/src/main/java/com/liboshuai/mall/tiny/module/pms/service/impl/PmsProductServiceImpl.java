package com.liboshuai.mall.tiny.module.pms.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.mall.tiny.module.pms.domain.dto.PmsProductAttributeValueES;
import com.liboshuai.mall.tiny.module.pms.domain.dto.PmsProductES;
import com.liboshuai.mall.tiny.module.pms.domain.entity.PmsProduct;
import com.liboshuai.mall.tiny.module.pms.domain.entity.PmsProductAttributeValue;
import com.liboshuai.mall.tiny.module.pms.domain.req.AddProductReq;
import com.liboshuai.mall.tiny.module.pms.domain.req.EsSearchProduct;
import com.liboshuai.mall.tiny.module.pms.mapper.PmsProductMapper;
import com.liboshuai.mall.tiny.module.pms.service.PmsProductAttributeValueService;
import com.liboshuai.mall.tiny.module.pms.service.PmsProductService;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.RestStatus;
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
        // 清空之前es中的数据
//        restHighLevelClient.deleteAll();
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

    private List<PmsProductES> getPmsProductES() {
        List<PmsProduct> pmsProductList = this.list();
        if (CollectionUtils.isEmpty(pmsProductList)) {
            log.warn("从数据库中导入所有商品到ES-查询全部product为空");
            return null;
        }
        List<PmsProductES> esProductList = pmsProductList.stream().filter(Objects::nonNull).map(product -> {
            PmsProductES esProduct = new PmsProductES();
            BeanUtils.copyProperties(product, esProduct);
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
