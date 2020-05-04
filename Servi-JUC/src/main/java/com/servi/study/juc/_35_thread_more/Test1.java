package com.servi.study.juc._35_thread_more;

public class Test1 {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        System.out.println("执行结束。");
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("mythread 执行结束。");
        }
    }
}
