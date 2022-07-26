package com.liboshuai.mall.tiny.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liboshuai.mall.tiny.domain.dao.SmsCouponProductRelation;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 优惠券和产品的关系表 Mapper 接口
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Mapper
public interface SmsCouponProductRelationMapper extends BaseMapper<SmsCouponProductRelation> {

}
