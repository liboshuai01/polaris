package com.liboshuai.mall.tiny.module.oms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liboshuai.mall.tiny.module.oms.domain.dao.OmsOrderOperateHistory;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单操作历史记录 Mapper 接口
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Mapper
public interface OmsOrderOperateHistoryMapper extends BaseMapper<OmsOrderOperateHistory> {

}
