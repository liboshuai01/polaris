package com.liboshuai.mall.tiny.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.mall.tiny.domain.dao.UmsMemberProductCategoryRelation;
import com.liboshuai.mall.tiny.mapper.UmsMemberProductCategoryRelationMapper;
import com.liboshuai.mall.tiny.service.UmsMemberProductCategoryRelationService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员与产品分类关系表（用户喜欢的分类） 服务实现类
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Service
public class UmsMemberProductCategoryRelationServiceImpl extends ServiceImpl<UmsMemberProductCategoryRelationMapper, UmsMemberProductCategoryRelation> implements UmsMemberProductCategoryRelationService {

}
