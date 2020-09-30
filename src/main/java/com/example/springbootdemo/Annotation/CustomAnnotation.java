package com.example.springbootdemo.Annotation;

import com.example.springbootdemo.pattern.strategy.Handler.OrderProperties;
import com.example.springbootdemo.pattern.strategy.annotation.OrderHandlerType;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-08-25
 **/
@Component
public class CustomAnnotation implements ApplicationListener<ContextRefreshedEvent> {


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 根容器为Spring容器
        if (event.getApplicationContext().getParent() == null) {
            Map<String, Object> beans = event.getApplicationContext().getBeansWithAnnotation(OrderHandlerType.class);

            Map<Integer,Class> map = new HashMap<>(16);

            for (Object bean : beans.values()) {
                //获取类上的注解
                OrderHandlerType ca = bean.getClass().getAnnotation(OrderHandlerType.class);
                System.out.println(bean.getClass().getName() + "===" + ca.value());
                map.put(ca.value(),bean.getClass());
                System.err.println("=====onApplicationEvent=====" + event.getSource().getClass().getName());
            }
            OrderProperties.of(map);




        }

    }
}
