package com.example.springbootdemo.scheduled.config;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @program: easysale-saas
 * @description: 异步线程配置类
 * @author: swd
 * @create: 2020-08-05
 **/
//@Configuration
public class AsyncConfig extends AsyncConfigurerSupport {


    @Override
    public Executor getAsyncExecutor() {
        return threadPoolTaskExecutor();
    }


    /**
     * 复用线程池,无界阻塞队列 用于执行任务
     * @return AsyncTaskExecutor
     */
    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程池大小
        executor.setCorePoolSize(7);
        //最大线程数
        executor.setMaxPoolSize(42);
        //队列桶的大小
        executor.setQueueCapacity(11);
        executor.setThreadNamePrefix("AsyncThreadPoolTaskExecutor-");
        executor.initialize();
        return executor;
    }

}
