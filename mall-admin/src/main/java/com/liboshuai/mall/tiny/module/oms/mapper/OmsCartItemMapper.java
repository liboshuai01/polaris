package com.liboshuai.mall.tiny.module.oms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liboshuai.mall.tiny.module.oms.domain.entity.OmsCartItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 购物车表 Mapper 接口
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Mapper
public interface OmsCartItemMapper extends BaseMapper<OmsCartItem> {

}
