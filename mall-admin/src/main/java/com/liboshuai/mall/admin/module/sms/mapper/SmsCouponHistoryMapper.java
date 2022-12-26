package com.liboshuai.mall.admin.module.sms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liboshuai.mall.admin.module.sms.domain.entity.SmsCouponHistory;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 优惠券使用、领取历史表 Mapper 接口
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Mapper
public interface SmsCouponHistoryMapper extends BaseMapper<SmsCouponHistory> {

}
