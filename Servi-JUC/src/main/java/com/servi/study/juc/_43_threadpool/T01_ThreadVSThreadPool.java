/**
 * 使用线程池比手动创建线程主要有三点好处。
 * <p>
 * 第一点，线程池可以解决线程生命周期的系统开销问题，同时还可以加快响应速度。
 * 因为线程池中的线程是可以复用的，我们只用少量的线程去执行大量的任务，这就大大减小了线程生命周期的开销。
 * 而且线程通常不是等接到任务后再临时创建，而是已经创建好时刻准备执行任务，这样就消除了线程创建所带来的延迟，
 * 提升了响应速度。
 * <p>
 * 第二点，线程池可以统筹内存和 CPU 的使用，避免资源使用不当。线程池会根据配置和任务数量灵活地控制线程数量，
 * 不够的时候就创建，太多的时候就回收，避免线程过多导致内存溢出，或线程太少导致 CPU 资源浪费，达到了一个平衡。
 * <p>
 * 第三点，线程池可以统一管理资源。比如线程池可以统一管理任务队列和线程，可以统一开始或结束任务，比单个线程逐一处理任务要更方便、
 * 更易于管理，同时也有利于数据统计，比如我们可以很方便地统计出已经执行过的任务的数量。
 */
package com.servi.study.juc._43_threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程和线程池运行效率比较
 * 126
 * 17
 */
public class T01_ThreadVSThreadPool implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }


    public static void main(String[] args) throws InterruptedException {

        T01_ThreadVSThreadPool runn = new T01_ThreadVSThreadPool();

        long start1 = System.currentTimeMillis();
        Thread[] threads = new Thread[1000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(runn);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 1000; i++) {
            service.execute(runn);
        }
        service.shutdown();

        while (!service.isTerminated()) {

        }
        long end2 = System.currentTimeMillis();

        System.out.println(end1 - start1);
        System.out.println(end2 - start2);

        //已完成的任务数量
        System.out.println(((ThreadPoolExecutor) service).getCompletedTaskCount());
    }
}
