package com.wupx.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * Redis 配置
 *
 * @author wupx
 * @date 2020/07/22
 */
@Configuration
public class RedisConfig {

    /**
     * 缓存管理器
     *
     * @param factory
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        // 生成默认配置，通过 Config 对象即可对缓存进行自定义配置
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                // 设置过期时间 30 分钟
                .entryTtl(Duration.ofMinutes(30))
                // 设置缓存前缀
                .prefixKeysWith("cache:user:")
                // 禁止缓存 null 值
                .disableCachingNullValues()
                // 设置 key 序列化
                .serializeKeysWith(keySerializationPair())
                // 设置 value 序列化
                .serializeValuesWith(valueSerializationPair());
        // 返回 Redis 缓存管理器
        return RedisCacheManager.builder(factory)
                .withCacheConfiguration("user", redisCacheConfiguration).build();
    }

    /**
     * key 序列化
     *
     * @return
     */
    private RedisSerializationContext.SerializationPair<String> keySerializationPair() {
        return RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer());
    }

    /**
     * value 序列化
     *
     * @return
     */
    private RedisSerializationContext.SerializationPair<Object> valueSerializationPair() {
        return RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());
    }
}
