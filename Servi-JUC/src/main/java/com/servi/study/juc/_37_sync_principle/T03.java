package com.servi.study.juc._37_sync_principle;

import org.openjdk.jol.info.ClassLayout;

public class T03 {
    private Object o = new Object();

    public T03() {
        System.out.println("new: " + ClassLayout.parseInstance(o).toPrintable());
    }

    public void m1() {
        synchronized (o) {
            int i = 0;
            while (i++ < 10) {
                System.out.println("m1-" + i + ": " + ClassLayout.parseInstance(o).toPrintable());
            }
            System.out.println("m1-11: " + ClassLayout.parseInstance(o).toPrintable());
        }
    }

    public void m2() {
        System.out.println("m2-1: " + ClassLayout.parseInstance(o).toPrintable());
        synchronized (o) {
            System.out.println("m2-2: " + ClassLayout.parseInstance(o).toPrintable());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        T03 lock = new T03();
        new Thread(lock::m1).start();
        new Thread(lock::m2).start();
    }
}
