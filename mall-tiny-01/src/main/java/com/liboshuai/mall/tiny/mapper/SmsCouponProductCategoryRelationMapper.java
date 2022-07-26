package com.liboshuai.mall.tiny.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liboshuai.mall.tiny.domain.dao.SmsCouponProductCategoryRelation;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 优惠券和产品分类关系表 Mapper 接口
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Mapper
public interface SmsCouponProductCategoryRelationMapper extends BaseMapper<SmsCouponProductCategoryRelation> {

}
