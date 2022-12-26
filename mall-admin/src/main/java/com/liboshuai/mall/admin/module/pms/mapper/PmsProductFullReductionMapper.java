package com.liboshuai.mall.admin.module.pms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liboshuai.mall.admin.module.pms.domain.entity.PmsProductFullReduction;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 产品满减表(只针对同商品) Mapper 接口
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Mapper
public interface PmsProductFullReductionMapper extends BaseMapper<PmsProductFullReduction> {

}
