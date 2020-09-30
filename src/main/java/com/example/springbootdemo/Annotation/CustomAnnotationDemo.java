package com.example.springbootdemo.Annotation;

import com.example.springbootdemo.pattern.strategy.annotation.OrderHandlerType;
import lombok.Data;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-08-25
 **/
//@Component
public class CustomAnnotationDemo implements ApplicationListener<ContextRefreshedEvent> {

    public static List<Invoker> invokerList = new ArrayList<>();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 根容器为Spring容器
        if (event.getApplicationContext().getParent() == null) {
            Map<String, Object> beans = event.getApplicationContext().getBeansWithAnnotation(OrderHandlerType.class);
            for (Object bean : beans.values()) {
                //获取类上的注解
                OrderHandlerType ca = bean.getClass().getAnnotation(OrderHandlerType.class);
                System.out.println(bean.getClass().getName() + "===" + ca.value());
                Method[] methods = bean.getClass().getMethods();
                for (Method declaredMethod : methods) {
                    System.out.println(declaredMethod.getName());
                    //获取方法上的注解
                    OrderHandlerType ma = AnnotationUtils.findAnnotation(declaredMethod, OrderHandlerType.class);
                    if (ma != null) {
                        invokerList.add(new Invoker(declaredMethod, String.valueOf(ma.value()), bean));
                        System.out.println(bean.getClass().getName() + "===" + ca.value() + "===" + ma.value());
                    }
                }
                Method[] declaredMethods = bean.getClass().getDeclaredMethods();
                for (Method declaredMethod : declaredMethods) {
                    System.out.println(declaredMethod.getName());
                    //获取参数的注解
                    OrderHandlerType ma = declaredMethod.getAnnotation(OrderHandlerType.class);
                    if (ma != null) {
                        System.out.println(bean.getClass().getName() + "===" + ca.value() + "===" + ma.value());
                    }
                }
            }
            System.err.println("=====onApplicationEvent=====" + event.getSource().getClass().getName());
        }
        invoke();
    }

    private void invoke() {
        for (Invoker invoker : invokerList) {
            try {
                invoker.getMethod().invoke(invoker.getBean(), invoker.getTag());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    @Data
    class Invoker {
        private Method method;
        private String tag;
        private Object bean;

        public Invoker(Method method, String tag, Object bean) {
            this.method = method;
            this.tag = tag;
            this.bean = bean;
        }
    }
}
