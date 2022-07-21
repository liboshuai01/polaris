package com.liboshuai.mall.tiny.service.impl;

import com.liboshuai.mall.tiny.redis.RedisService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: liboshuai
 * @Date: 2022-07-21 13:35
 * @Description:
 */
@Service
@NoArgsConstructor
public class RedisServiceImpl implements RedisService {

    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    public RedisServiceImpl(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * 存储数据
     */
    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key,value);
    }

    /**
     * 获取数据
     */
    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 设置超期时间
     */
    @Override
    public boolean expire(String key, long expire) {
        return stringRedisTemplate.expire(key,expire, TimeUnit.SECONDS);
    }

    /**
     * 删除数据
     */
    @Override
    public void remove(String key) {
        stringRedisTemplate.delete(key);
    }

    /**
     * 自增操作
     */
    @Override
    public Long increment(String key, long delta) {
        return stringRedisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 判断key是否存在
     */
    @Override
    public boolean exists(String key) {
        return stringRedisTemplate.hasKey(key);
    }
}
