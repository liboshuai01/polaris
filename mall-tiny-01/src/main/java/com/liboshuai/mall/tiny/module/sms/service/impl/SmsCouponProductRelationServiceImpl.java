package com.liboshuai.mall.tiny.module.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.mall.tiny.module.sms.domain.dao.SmsCouponProductRelation;
import com.liboshuai.mall.tiny.module.sms.mapper.SmsCouponProductRelationMapper;
import com.liboshuai.mall.tiny.module.sms.service.SmsCouponProductRelationService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 优惠券和产品的关系表 服务实现类
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Service
public class SmsCouponProductRelationServiceImpl extends ServiceImpl<SmsCouponProductRelationMapper, SmsCouponProductRelation> implements SmsCouponProductRelationService {

}
