package com.liboshuai.mall.tiny.module.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liboshuai.mall.tiny.module.pms.domain.entity.PmsProduct;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
public interface PmsProductService extends IService<PmsProduct> {
//    /**
//     * 从数据库中导入所有商品到ES
//     */
//    int importAll();
//
//    /**
//     * 根据id删除商品
//     */
//    void delete(Long id);
//
//    /**
//     * 根据id创建商品
//     */
//    EsProduct create(Long id);
//
//    /**
//     * 批量删除商品
//     */
//    void delete(List<Long> ids);
//
//    /**
//     * 根据关键字搜索名称或者副标题
//     */
//    Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 从数据库中导入所有商品到ES
     */
    int importAllProductToEs();

    /**
     * 根据id批量删除商品
     */
    int deleteProductById(Long id);

    /**
     * 批量添加/修改商品信息
     */
    int saveOrUpdateProduct();
}
