package com.example.springbootdemo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.cache.RedisCacheManager;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * 自定义CacheManagerCustomizer，目的：默认过期时间3600秒，可自定义过期时间
 *
 * @author ZhouXin
 */
@Configuration
@AutoConfigureBefore(CacheAutoConfiguration.class)
@EnableConfigurationProperties(RedisCacheManagerProperties.class)
public class RedisCacheManagerCustomizer {

    @Autowired
    private Environment environment;

    @Autowired
    private RedisCacheManagerProperties redisCacheManagerProperties;

    @Bean
    public CacheManagerCustomizer<RedisCacheManager> customize() {
        String cachePrefix = "release";
        return cacheManager -> {
            cacheManager.setDefaultExpiration(redisCacheManagerProperties.getDefaultExpiration());
            final Map<String, Long> expires = redisCacheManagerProperties.getExpires().stream()
                    .filter(p -> p.contains(":"))
                    .collect(Collectors.toMap(p -> p.split(":")[0], p -> Long.valueOf(p.split(":")[1])));
            cacheManager.setExpires(expires);
            // 使用全局redis前缀
            cacheManager.setUsePrefix(true);
            cacheManager.setCachePrefix(cacheName -> (cachePrefix + ":" + cacheName + ":").getBytes());

        };
    }
}
