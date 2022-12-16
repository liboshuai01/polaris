package com.liboshuai.mall.tiny.module.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liboshuai.mall.tiny.compone.response.ResponseResult;
import com.liboshuai.mall.tiny.module.pms.domain.dto.PmsBrandDTO;
import com.liboshuai.mall.tiny.module.pms.domain.dto.PmsProductES;
import com.liboshuai.mall.tiny.module.pms.domain.entity.PmsProduct;

import java.util.List;


/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
public interface PmsProductService extends IService<PmsProduct> {

    /**
     * 从数据库中导入所有商品到ES
     */
    boolean importAllProductToEs();

    /**
     * es精确查询测试
     */
    List<PmsProductES> testTermQuery();

    /**
     * es查询全部数据
     */
    List<PmsProductES> testMatchAllQuery();

    /**
     * es查询匹配数据
     */
    List<PmsProductES> testMatchQuery(String name);

    /**
     * es词语匹配查询
     */
    ResponseResult<List<PmsProductES>> testMatchPhraseQuery(String name);

    /**
     * es内容在多字段中进行查询
     */
    ResponseResult<List<PmsProductES>> testMatchMultiQuery(String query);

    /**
     * es通配符查询
     */
    ResponseResult<List<PmsProductES>> testWildcardQuery(String name);

    /**
     * es模糊查询
     */
    ResponseResult<List<PmsProductES>> testFuzzQuery(String subTitle);

    /**
     * es分页查询
     */
    ResponseResult<List<PmsProductES>> testPageQuery(int pageNum, int pageSize);

    /**
     * es排序查询
     */
    ResponseResult<List<PmsProductES>> testSortQuery();

    /**
     * es滚动查询
     */
    ResponseResult<List<PmsProductES>> testScrollQuery(int pageNum, int pageSize);

    /**
     * 根据id删除es中的商品
     */
//    void deleteEsProductById(Long id);

    /**
     * 批量添加商品信息
     */
//    int addProduct(List<AddProductReq> addProductReqs);

    /**
     * 根据商品名称,商品副标题,商品关键字分页搜索商品信息
     */
//    Page<EsProduct> esProductSearch(EsSearchProduct esSearchProduct);
}
