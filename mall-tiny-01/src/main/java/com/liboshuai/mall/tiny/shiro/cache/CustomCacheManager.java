package com.liboshuai.mall.tiny.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author: liboshuai
 * @Date: 2022-09-12 19:27
 * @Description: 重写Shiro缓存管理器
 */
public class CustomCacheManager implements CacheManager {

    private RedisTemplate<String, Object> redisTemplate;

    public CustomCacheManager(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return new CustomCache<K, V>(redisTemplate);
    }
}
