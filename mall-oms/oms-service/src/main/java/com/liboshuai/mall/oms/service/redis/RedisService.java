package com.liboshuai.mall.oms.service.redis;

import org.springframework.stereotype.Service;

/**
 * @Author: liboshuai
 * @Date: 2022-07-21 13:31
 * @Description: 用于操作redis的service接口
 */
@Service
public interface RedisService {
    /**
     * 存储数据
     */
    void set(String key, String value);

    /**
     * 获取数据
     */
    String get(String key);

    /**
     * 设置超期时间
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     */
    void remove(String key);

    /**
     * 自增操作
     */
    Long increment(String key, long delta);

    /**
     * 判断key是否存在
     */
    boolean exists(String key);
}
