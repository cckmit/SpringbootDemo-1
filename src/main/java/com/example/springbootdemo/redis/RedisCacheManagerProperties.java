package com.example.springbootdemo.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Collections;
import java.util.List;

/**
 * Created by lifeng on 16-11-17.
 */
@ConfigurationProperties(prefix = "spring.cache")
public class RedisCacheManagerProperties {


    private Integer defaultExpiration = 3600;

    private List<String> expires = Collections.emptyList();

    public Integer getDefaultExpiration() {
        return defaultExpiration;
    }

    public void setDefaultExpiration(Integer defaultExpiration) {
        this.defaultExpiration = defaultExpiration;
    }

    public List<String> getExpires() {
        return expires;
    }

    public void setExpires(List<String> expires) {
        this.expires = expires;
    }
}
