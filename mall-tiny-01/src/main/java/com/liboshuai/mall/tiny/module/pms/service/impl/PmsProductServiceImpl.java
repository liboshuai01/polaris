package com.liboshuai.mall.tiny.module.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.mall.tiny.module.pms.domain.entity.PmsProduct;
import com.liboshuai.mall.tiny.module.pms.domain.entity.PmsProductAttributeValue;
import com.liboshuai.mall.tiny.module.pms.domain.req.ProductSaveOrUpdateReq;
import com.liboshuai.mall.tiny.module.pms.domain.req.ProductSearchReq;
import com.liboshuai.mall.tiny.module.pms.mapper.PmsProductMapper;
import com.liboshuai.mall.tiny.module.pms.service.PmsProductAttributeValueService;
import com.liboshuai.mall.tiny.module.pms.service.PmsProductService;
import com.liboshuai.mall.tiny.nosql.elasticsearch.document.EsProduct;
import com.liboshuai.mall.tiny.nosql.elasticsearch.document.EsProductAttributeValue;
import com.liboshuai.mall.tiny.nosql.elasticsearch.repository.EsProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

//
//    @Override
//    public void delete(Long id) {
//        productRepository.deleteById(id);
//    }
//
//    @Override
//    public EsProduct create(Long id) {
//        EsProduct result = null;
//        List<EsProduct> esProductList = productDao.getAllEsProductList(id);
//        if (esProductList.size() > 0) {
//            EsProduct esProduct = esProductList.get(0);
//            result = productRepository.save(esProduct);
//        }
//        return result;
//    }
//
//    @Override
//    public void delete(List<Long> ids) {
//        if (!CollectionUtils.isEmpty(ids)) {
//            List<EsProduct> esProductList = new ArrayList<>();
//            for (Long id : ids) {
//                EsProduct esProduct = new EsProduct();
//                esProduct.setId(id);
//                esProductList.add(esProduct);
//            }
//            productRepository.deleteAll(esProductList);
//        }
//    }
//
//    @Override
//    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
//        Pageable pageable = PageRequest.of(pageNum, pageSize);
//        return productRepository.findByNameOrSubTitleOrKeywords(keyword, keyword, keyword, pageable);
//    }



    @Autowired
    private PmsProductAttributeValueService pmsProductAttributeValueService;

    @Autowired
    private EsProductRepository esProductRepository;

//    @Override
//    public int importAll() {
//        List<EsProduct> esProductList = productDao.getAllEsProductList(null);
//        Iterable<EsProduct> esProductIterable = productRepository.saveAll(esProductList);
//        Iterator<EsProduct> iterator = esProductIterable.iterator();
//        int result = 0;
//        while (iterator.hasNext()) {
//            result++;
//            iterator.next();
//        }
//        return result;
//    }
    /**
     * 从数据库中导入所有商品到ES
     */
    @Override
    public int importAllProductToEs() {
        List<PmsProduct> pmsProductList = this.list();
        List<EsProduct> esProductList = pmsProductList.stream().filter(Objects::nonNull).map(product -> {
            EsProduct esProduct = new EsProduct();
            BeanUtils.copyProperties(product, esProduct);
            return esProduct;
        }).collect(Collectors.toList());
        List<Long> pmsProductIdList = pmsProductList.stream().map(PmsProduct::getId).collect(Collectors.toList());
        // fixme: 逻辑带确认
//        List<PmsProductAttributeValue> pmsProductAttributeValues = pmsProductAttributeValueService.lambdaQuery()
//                .eq(PmsProductAttributeValue::getProductId, product.getId()).list();
//
//        List<EsProductAttributeValue> attrValueList = new ArrayList<>();
//        esProduct.setAttrValueList();
        Iterable<EsProduct> esProductIterable = esProductRepository.saveAll(esProductList);
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
