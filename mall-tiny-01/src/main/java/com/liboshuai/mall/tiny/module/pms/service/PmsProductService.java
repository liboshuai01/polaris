package com.liboshuai.mall.tiny.module.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liboshuai.mall.tiny.module.pms.domain.entity.PmsProduct;
import com.liboshuai.mall.tiny.module.pms.domain.req.ProductSaveOrUpdateReq;
import com.liboshuai.mall.tiny.module.pms.domain.req.ProductSearchReq;
import com.liboshuai.mall.tiny.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;

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
    int importAllProductToEs();

    /**
     * 根据id删除es中的商品
     */
    void deleteEsProductById(Long id);

    /**
     * 批量添加商品信息
     */
    int addProduct(List<ProductSaveOrUpdateReq> productSaveOrUpdateReqs);

    /**
     * 根据商品名称,商品副标题,商品关键字分页搜索商品信息
     */
    Page<EsProduct> productSearch(ProductSearchReq productSearchReq);
}
