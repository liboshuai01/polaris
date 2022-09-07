package com.liboshuai.mall.tiny.module.pms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liboshuai.mall.tiny.module.pms.domain.dao.PmsProductLadder;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 产品阶梯价格表(只针对同商品) Mapper 接口
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Mapper
public interface PmsProductLadderMapper extends BaseMapper<PmsProductLadder> {

}
