package com.servi.study.juc._35_thread_more;

/**
 * Interrupted
 */
public class TestInterrupted {
    public static void main(String[] args) throws InterruptedException {

        Thread.currentThread().interrupt();
        System.out.println("停止？：" + Thread.interrupted());
        System.out.println("停止？：" + Thread.interrupted());
    }
}
