package com.servi.study.juc._34_Q;

/**
 * volatile 保证可见性和有序性 解释原子性问题
 */
public class Q3 {
    private static volatile int count = 0;

    private void add() {
        int i = 0;
        while (i++ < 10000) {
            synchronized (this) {
                count += 1;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Q3 q = new Q3();

        //Q3 q1 = new Q3();
        // 创建两个线程，执行add()操作
        Thread t1 = new Thread(q::add);
        Thread t2 = new Thread(q::add);

        // 启动两个线程
        t1.start();
        t2.start();
        // 等待两个线程执行结束
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
