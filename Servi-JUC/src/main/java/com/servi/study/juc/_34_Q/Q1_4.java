package com.servi.study.juc._34_Q;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 缓存带来的可见性问题
 */
public class Q1_4 {
    AtomicBoolean retry = new AtomicBoolean(true);
    private void retry() {
        System.out.println(" retry start ");
        while (retry.get()){}
        System.out.println(" retry end ");
    }

    public static void main(String[] args) throws InterruptedException {
        Q1_4 q = new Q1_4();
        // 创建线程，执行retry()操作
        Thread t1 = new Thread(q::retry);
        // 启动线程
        t1.start();
        //等待 1 秒
        Thread.sleep(1000);
        //停止 retry
        q.retry.compareAndSet(true,false);
        System.out.println(" set retry stop ");
        // 等待线程执行结束
        t1.join();
    }
}







