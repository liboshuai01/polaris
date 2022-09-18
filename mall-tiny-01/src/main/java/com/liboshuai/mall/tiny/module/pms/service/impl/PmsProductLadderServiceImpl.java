package com.liboshuai.mall.tiny.module.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.mall.tiny.module.pms.domain.entity.PmsProductLadder;
import com.liboshuai.mall.tiny.module.pms.mapper.PmsProductLadderMapper;
import com.liboshuai.mall.tiny.module.pms.service.PmsProductLadderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品阶梯价格表(只针对同商品) 服务实现类
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Service
public class PmsProductLadderServiceImpl extends ServiceImpl<PmsProductLadderMapper, PmsProductLadder> implements PmsProductLadderService {

}
