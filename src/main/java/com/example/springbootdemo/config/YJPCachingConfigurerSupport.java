package com.example.springbootdemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.SimpleCacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-08-19
 **/
@Configuration
public class YJPCachingConfigurerSupport extends CachingConfigurerSupport {
    @Bean
    @Override
    public CacheErrorHandler errorHandler() {
       return new JdkSerialCacheErrorHandler();
    }
}
 class JdkSerialCacheErrorHandler extends SimpleCacheErrorHandler {

    private static final Logger LOG = LoggerFactory.getLogger(JdkSerialCacheErrorHandler.class);

    /**
     * Get异常处理策略: 视为未命中, 并清空缓存.
     *
     * @param exception 异常
     * @param cache     缓存
     * @param key       缓存Key
     */
    @Override
    public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
        if (LOG.isWarnEnabled()) {
            LOG.warn("忽略缓存获取异常: " + key + "@" + cache.getName(), exception);
            // 忽略缓存获取异常: com.yijiupi.himalaya.easysale.user.domain.bl.dealerpc.TransportTemplateBLselectTransportTemplateList:[{"pageNum":1,"pageSize":10,"shopId":"201964061080707101"}]@transportTemplateCaching
        }
    }

}
