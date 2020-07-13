package com.servi.study.juc._43_threadpool;

import java.util.concurrent.*;

/**
 * LinkedBlockingQueue
 * ArrayBlockingQueue
 * DelayQueue
 * SynchronousQueue
 */
public class T05_BlockingQueue {

    /**
     * LinkedBlockingQueue 可以认为是一种无界队列，传入容量变成有界
     */
    private static BlockingQueue queue1 = new LinkedBlockingQueue<>();

    /**
     * 容量为0的队列
     */
    private static BlockingQueue queue2 = new SynchronousQueue<String>();

    /**
     * 指定大小的队列
     */
    private static BlockingQueue queue3 = new ArrayBlockingQueue<String>(3);

    /**
     * 延迟队列
     */
    private static BlockingQueue queue4 = new DelayQueue();
}
