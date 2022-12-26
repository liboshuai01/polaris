package com.liboshuai.mall.admin.module.pms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liboshuai.mall.admin.module.pms.domain.entity.PmsProductLadder;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 产品阶梯价格表(只针对同商品) Mapper 接口
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Mapper
public interface PmsProductLadderMapper extends BaseMapper<PmsProductLadder> {

}
