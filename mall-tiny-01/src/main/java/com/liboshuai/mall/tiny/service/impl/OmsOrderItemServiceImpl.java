package com.liboshuai.mall.tiny.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.mall.tiny.domain.dao.OmsOrderItem;
import com.liboshuai.mall.tiny.mapper.OmsOrderItemMapper;
import com.liboshuai.mall.tiny.service.OmsOrderItemService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单中所包含的商品 服务实现类
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-25
 */
@Service
public class OmsOrderItemServiceImpl extends ServiceImpl<OmsOrderItemMapper, OmsOrderItem> implements OmsOrderItemService {

}
