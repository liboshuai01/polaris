package com.liboshuai.mall.tiny.common.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2022-11-28 13:59
 * @Description: 自定义myabtisPlusMapper
 */
public interface MyBaseMapper<T> extends BaseMapper<T> {

    int updateBatchByIds(@Param("entity") T entity, @Param("ids") List<Integer> ids);

    int insertBatch(@Param("list") List<T> list);
}
