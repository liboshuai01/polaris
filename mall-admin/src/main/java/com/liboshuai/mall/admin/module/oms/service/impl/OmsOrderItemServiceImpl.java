package com.liboshuai.mall.admin.module.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.mall.admin.module.oms.domain.entity.OmsOrderItem;
import com.liboshuai.mall.admin.module.oms.mapper.OmsOrderItemMapper;
import com.liboshuai.mall.admin.module.oms.service.OmsOrderItemService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单中所包含的商品 服务实现类
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Service
public class OmsOrderItemServiceImpl extends ServiceImpl<OmsOrderItemMapper, OmsOrderItem> implements OmsOrderItemService {

}
