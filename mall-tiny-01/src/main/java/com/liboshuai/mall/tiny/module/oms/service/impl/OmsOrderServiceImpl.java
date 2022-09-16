package com.liboshuai.mall.tiny.module.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.mall.tiny.module.oms.domain.entity.OmsOrder;
import com.liboshuai.mall.tiny.module.oms.mapper.OmsOrderMapper;
import com.liboshuai.mall.tiny.module.oms.service.OmsOrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Service
public class OmsOrderServiceImpl extends ServiceImpl<OmsOrderMapper, OmsOrder> implements OmsOrderService {

}
