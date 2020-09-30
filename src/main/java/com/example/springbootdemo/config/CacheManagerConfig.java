package com.example.springbootdemo.config;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-08-21
 **/
@Configuration
public class CacheManagerConfig{
    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    @PostConstruct
    public void init() {
        // 设置序列化
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        // value序列化
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
    }


    @Bean("yjxKeyGenerator")
    public KeyGenerator keyGenerator() {
        return (target,method,params)->{
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(method.getName());
            sb.append(":");
            sb.append(JSON.toJSONString(params));
            return sb.toString();
        };
    }


}
