package com.liboshuai.mall.tiny.module.pms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liboshuai.mall.tiny.module.pms.domain.entity.PmsSkuStock;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * sku的库存 Mapper 接口
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Mapper
public interface PmsSkuStockMapper extends BaseMapper<PmsSkuStock> {

}
