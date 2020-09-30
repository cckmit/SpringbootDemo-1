package com.example.springbootdemo.config;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo.pattern.strategy.annotation.OrderHandlerType;
import com.example.springbootdemo.utils.ClassScaner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-08-20
 **/
@Slf4j
//@Component
@SuppressWarnings({"unused","rawtypes"})
public class HandlerProcessor implements BeanFactoryPostProcessor {

    private String basePackage = "com.example.springbootdemo.pattern.strategy.serviceimpl";


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<Integer,Class> map = new HashMap<>(16);

        ClassScaner.scan(basePackage, OrderHandlerType.class).forEach(x ->{
            Integer type = x.getAnnotation(OrderHandlerType.class).value();
            map.put(type,x);
        });

        beanFactory.registerSingleton(OrderHandlerType.class.getName(), map);

        log.info("处理器初始化{}", JSONObject.toJSONString(beanFactory.getBean(OrderHandlerType.class.getName())));
    }
}
