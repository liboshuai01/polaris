package com.liboshuai.mall.tiny.common.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2022-11-28 13:59
 * @Description: 自定义myabtisPlusMapper
 */
public interface RootMapper<T> extends BaseMapper<T> {


    /**
     * 自定义批量插入
     * 如果要自动填充，@Param(xx) xx参数名必须是 list/collection/array 3个的其中之一
     */
    int insertBatch(@Param("list") List<T> list);

    /**
     * 自定义批量更新，条件为主键
     * 如果要自动填充，@Param(xx) xx参数名必须是 list/collection/array 3个的其中之一
     */
    int updateBatch(@Param("list") List<T> list);

}
