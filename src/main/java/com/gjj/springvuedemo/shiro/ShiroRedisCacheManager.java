package com.gjj.springvuedemo.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * shiro-redis缓存配置管理器
 *
 * @author gjj
 * @project spring-vue-demo
 * @date 2018-04-19 10:07
 **/
public class ShiroRedisCacheManager implements CacheManager {

    private RedisTemplate<Object, Object> redisTemplate;

    public ShiroRedisCacheManager(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return (Cache<K, V>) new ShiroRedisCache<Object, Object>(redisTemplate);
    }
}
