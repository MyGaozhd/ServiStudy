package com.servi.study.juc._14_MoreSync;

public class DoNotLockInteger {
    Integer s1 = 1;
    Integer s2 = 1;

    void m1() {
        synchronized (s1) {
            System.out.println("m1");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void m2() {
        synchronized (s2) {
            System.out.println("m2");
            try {
                Thread.sleep(80000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        DoNotLockInteger t = new DoNotLockInteger();
        new Thread(t::m1).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(t::m2).start();
    }
}
