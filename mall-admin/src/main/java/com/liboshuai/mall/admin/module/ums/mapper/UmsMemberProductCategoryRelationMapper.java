package com.liboshuai.mall.admin.module.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liboshuai.mall.admin.module.ums.domain.entity.UmsMemberProductCategoryRelation;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 会员与产品分类关系表（用户喜欢的分类） Mapper 接口
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Mapper
public interface UmsMemberProductCategoryRelationMapper extends BaseMapper<UmsMemberProductCategoryRelation> {

}
