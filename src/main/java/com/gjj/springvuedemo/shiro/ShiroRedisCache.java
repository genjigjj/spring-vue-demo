package com.gjj.springvuedemo.shiro;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * redis cache
 *
 * @author gjj
 * @project spring-vue-demo
 * @date 2018-04-19 10:20
 **/
public class ShiroRedisCache<K, V> implements Cache<K, V> {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private RedisTemplate<K, V> redisTemplate;

    private String prefix = "shiro:";

    ShiroRedisCache(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public V get(K key) throws CacheException {
        if (key == null) {
            return null;
        }
        return redisTemplate.opsForValue().get(this.prefix + key);
    }

    @Override
    public V put(K key, V value) throws CacheException {
        if (value == null) {
            return null;
        }
        redisTemplate.opsForValue().set((K) (this.prefix + key), value);
        redisTemplate.expire((K) (this.prefix + key), 30, TimeUnit.MINUTES);
        return value;
    }

    @Override
    public V remove(K key) throws CacheException {
        if (!(key instanceof String)) {
            return null;
        }
        ValueOperations<K, V> vo = redisTemplate.opsForValue();
        V value = vo.get(key);
        redisTemplate.delete((K) key);
        return value;
    }

    @Override
    public void clear() throws CacheException {
        redisTemplate.getConnectionFactory().getConnection().flushDb();
    }

    @Override
    public int size() {
        Long len = redisTemplate.getConnectionFactory().getConnection().dbSize();
        return len.intValue();
    }

    @Override
    public Set<K> keys() {
        Set<K> set = redisTemplate.keys((K) (prefix + "*"));
        Set<K> result = new HashSet<>();
        if (CollectionUtils.isEmpty(set)) {
            return Collections.emptySet();
        }
        for (K key : set) {
            result.add(key);
        }
        return result;
    }

    @Override
    public Collection<V> values() {
        Set<K> keys = keys();
        List<V> values = new ArrayList<>(keys.size());
        for (K k : keys) {
            values.add(redisTemplate.opsForValue().get(k));
        }
        return values;
    }

}
