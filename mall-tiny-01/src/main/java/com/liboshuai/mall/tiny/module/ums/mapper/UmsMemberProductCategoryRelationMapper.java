package com.liboshuai.mall.tiny.module.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liboshuai.mall.tiny.module.ums.domain.dao.UmsMemberProductCategoryRelation;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 会员与产品分类关系表（用户喜欢的分类） Mapper 接口
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Mapper
public interface UmsMemberProductCategoryRelationMapper extends BaseMapper<UmsMemberProductCategoryRelation> {

}
