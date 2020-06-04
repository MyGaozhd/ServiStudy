/**
 * 实现方案
 * 1、集成 Thread 类
 * 2、实现 Runnable 接口
 */
package com.servi.study.juc._00;

public class T02_HowToCreateThread {
//    static class MyThread1 extends Thread {
//
//        public MyThread1(Runnable r){
//            super(r);
//        }
//
//        @Override
//        public void run() {
//            System.out.println("Hello MyThread!");
//        }
//    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyThread!");
        }
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRun!");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();

//        new MyThread1(new MyRun()).start();
    }
}
