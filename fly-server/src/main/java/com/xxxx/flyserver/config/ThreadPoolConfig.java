package com.xxxx.flyserver.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: fly
 * @description: 线程池配置类
 * @author: cxf
 * @create: 2022-04-11 14:52
 **/
@Configuration
public class ThreadPoolConfig {
    /**
     * 获取当前cup个数
     */
    int cupNums = Runtime.getRuntime().availableProcessors();
    /**
     * 线程池的最大线程数
     */
    private int maximumPoolSize = cupNums * 5;

    @Bean(value = "threadPool")
    public ExecutorService buildThreadPool(){
        int corePoolSize = 10;
        return new ThreadPoolExecutor(corePoolSize,maximumPoolSize, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(100),new ThreadFactoryBuilder().setNameFormat("Thread_cxf-%d").build());
    }
}
