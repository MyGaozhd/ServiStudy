/**
 * 分析一下这个程序的输出
 */
package com.servi.study.juc._05;

public class T implements Runnable {

    private /*volatile*/ int count = 0;

    public /*synchronized*/ void run() {
        count++;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        T t = new T();
        for (int i = 0; i < 10000; i++) {
            new Thread(t::run, "THREAD" + i).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.count);
    }

}
