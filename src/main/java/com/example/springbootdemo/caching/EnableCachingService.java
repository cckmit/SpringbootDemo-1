package com.example.springbootdemo.caching;

import com.google.common.collect.Lists;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-08-19
 **/
@Service
public class EnableCachingService {

    private List<EnableCachingBean> list = Lists.newArrayList();

    //@CachePut(value = "user", key = "#entity.id") // 将返回结果更新到缓存中
    @CacheEvict(value = "shopJpRelationCaching",allEntries=true)
    public void insert(EnableCachingBean bean){
        System.out.println("insert--->"+bean.toString());
        list.add(bean);
    }

    @CacheEvict(value = "shopJpRelationCaching",allEntries=true)
    public void delete(EnableCachingBean bean){
        System.out.println("delete--->"+bean.toString());
        list.add(bean);
    }

    @Cacheable(value = "shopJpRelationCaching",keyGenerator = "yjxKeyGenerator",unless = "#result == null")
    public  EnableCachingBean select(EnableCachingBean bean){
        System.out.println("select--->"+bean.toString());
        return bean;
    }

    @Cacheable(value = "shopJpRelationCaching",unless = "#result == null",keyGenerator = "yjxKeyGenerator")
    public  String getBuId(String id){
        System.out.println("select--->"+id);
        return "getBuId";
    }


    @Cacheable(value = "shopJpRelationCaching",unless = "#result == null",cacheManager = "yjxCacheManager",keyGenerator = "yjxKeyGenerator")
    public  String selectAll(){
        System.out.println("selectAll--->");
        return "getBuId";
    }
}
