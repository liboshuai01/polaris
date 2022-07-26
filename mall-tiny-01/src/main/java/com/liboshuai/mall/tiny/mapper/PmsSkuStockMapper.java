package com.liboshuai.mall.tiny.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liboshuai.mall.tiny.domain.dao.PmsSkuStock;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * sku的库存 Mapper 接口
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-25
 */
@Mapper
public interface PmsSkuStockMapper extends BaseMapper<PmsSkuStock> {

}
