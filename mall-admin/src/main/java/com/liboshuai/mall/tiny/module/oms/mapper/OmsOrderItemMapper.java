package com.liboshuai.mall.tiny.module.oms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liboshuai.mall.tiny.module.oms.domain.entity.OmsOrderItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单中所包含的商品 Mapper 接口
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Mapper
public interface OmsOrderItemMapper extends BaseMapper<OmsOrderItem> {

}
