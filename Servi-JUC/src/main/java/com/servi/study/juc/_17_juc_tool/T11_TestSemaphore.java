package com.servi.study.juc._17_juc_tool;

import java.util.concurrent.Semaphore;

/**
 * 用来做限流
 */
public class T11_TestSemaphore {
    public static void main(String[] args) {
        //Semaphore s = new Semaphore(2);
        Semaphore s = new Semaphore(1, true);
        //允许一个线程同时执行
        //Semaphore s = new Semaphore(1);

        new Thread(() -> {
            try {
                s.acquire();

                System.out.println("T1 running...start");
                Thread.sleep(200);
                System.out.println("T1 running...end");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        }).start();

        new Thread(() -> {
            try {
                s.acquire();

                System.out.println("T2 running...start");
                Thread.sleep(200);
                System.out.println("T2 running...end");

                s.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
