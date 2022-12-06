//package com.liboshuai.mall.tiny.nosql.elasticsearch.repository;
//
//import com.liboshuai.mall.tiny.nosql.elasticsearch.document.EsProduct;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
//
///**
// * @Author: liboshuai
// * @Date: 2022-12-02 16:20
// * @Description: es商品数据层
// */
//public interface EsProductRepository extends ElasticsearchRepository<EsProduct, Long> {
//
//    /**
//     * 根据商品名称,商品标题,商品关键字 分页查询
//     * @param name 商品名称
//     * @param subTitle 商品标题
//     * @param keywords 商品关键字
//     * @return 分页查询的结果
//     */
//    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keywords, Pageable pageable);
//
//}
