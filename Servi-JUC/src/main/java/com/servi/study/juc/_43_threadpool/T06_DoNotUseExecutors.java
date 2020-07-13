package com.servi.study.juc._43_threadpool;

import java.util.concurrent.Executors;

public class T06_DoNotUseExecutors {

    public static void main(String[] args) {

        /**
         *LinkedBlockingQueue -> OOM
         */
        Executors.newFixedThreadPool(1);

        /**
         * LinkedBlockingQueue->OOM
         */
        Executors.newSingleThreadExecutor();

        /**
         * max -> Integer.MAX_VALUE
         */
        Executors.newCachedThreadPool();

        /**
         * DelayedWorkQueue -> OOM
         */
        Executors.newScheduledThreadPool(1);

        /**
         * DelayedWorkQueue -> OOM
         */
        Executors.newSingleThreadScheduledExecutor();
    }
}
