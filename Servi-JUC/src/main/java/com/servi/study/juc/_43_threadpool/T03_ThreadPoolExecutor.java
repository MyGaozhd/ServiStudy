package com.servi.study.juc._43_threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池的各个参数的含义
 * int corePoolSize,  核心线程数
 * int maximumPoolSize, 最大线程数
 * long keepAliveTime, 存活时间
 * TimeUnit unit, 时间单位
 * BlockingQueue<Runnable> workQueue, 用来存放任务的队列
 * ThreadFactory threadFactory, 线程工厂，用来创建线程
 * RejectedExecutionHandler handler 处理被拒绝的任务
 */
public class T03_ThreadPoolExecutor {


    public static void main(String[] args) {

        ExecutorService executor = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(), new ThreadFactory() {
            private AtomicInteger count = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "ssc-thread" + count.getAndIncrement());
            }
        }, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("拒绝。。。。。");
            }
        });

        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }
}
