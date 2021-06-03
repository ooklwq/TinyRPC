package com.tinyrpc.utils.concurrent.threadpool;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import lombok.extern.slf4j.Slf4j;

/**
 * 创建线城市的工具类
 */
@Slf4j
public class ThreadPoolFactoryUtils {

    /**
     * 通过 threadNamePrefix 区别不同的线程池（把相同threadNamePredix的线程池看作是为同一业务场景服务）
     * key: threadNamePrefix
     * value: threadPool
     */
    private static final Map<String, ExecutorService> THREAD_POOLS = new ConcurrentHashMap<>();

    private ThreadPoolFactoryUtils(){}

    public static ExecutorService createCustomThreadPoolIfAbsent(CustomThreadPoolConfig customThreadPoolConfig, String threadNamePrefix,
        Boolean deamon) {
        ExecutorService threadPool = THREAD_POOLS.computeIfAbsent(threadNamePrefix, k -> createThreadPool(customThreadPoolConfig, threadNamePrefix, deamon));
        // 如果 threadPool 被 shutdown的话就重新创建一个
        if (threadPool.isShutdown() || threadPool.isTerminated()) {

        }
    }

    public static ExecutorService createThreadPool(CustomThreadPoolConfig customThreadPoolConfig, String threadNamePrefix, Boolean daemon) {

    }
}
