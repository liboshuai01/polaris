package com.liboshuai.mall.tiny.module.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.mall.tiny.module.pms.domain.entity.PmsProduct;
import com.liboshuai.mall.tiny.module.pms.domain.req.ProductSaveOrUpdateReq;
import com.liboshuai.mall.tiny.module.pms.domain.req.ProductSearchReq;
import com.liboshuai.mall.tiny.module.pms.mapper.PmsProductMapper;
import com.liboshuai.mall.tiny.module.pms.service.PmsProductService;
import com.liboshuai.mall.tiny.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 从数据库中导入所有商品到ES
     */
    @Override
    public int importAllProductToEs() {
        return 0;
    }

    /**
     * 根据id批量删除商品
     *
     * @param id
     */
    @Override
    public int deleteProductById(Long id) {
        return 0;
    }

    /**
     * 批量添加/修改商品信息
     *
     * @param productSaveOrUpdateReqs
     */
    @Override
    public int saveOrUpdateProduct(List<ProductSaveOrUpdateReq> productSaveOrUpdateReqs) {
        return 0;
    }

    /**
     * 根据商品名称,商品副标题,商品关键字分页搜索商品信息
     *
     * @param productSearchReq
     */
    @Override
    public Page<EsProduct> productSearch(ProductSearchReq productSearchReq) {
        return null;
    }
}
