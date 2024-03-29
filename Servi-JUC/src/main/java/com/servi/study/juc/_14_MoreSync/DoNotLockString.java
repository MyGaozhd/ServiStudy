/**
 * 不要以字符串常量作为锁定对象
 */
package com.servi.study.juc._14_MoreSync;

public class DoNotLockString {

    String s1 = "Hello";
    String s2 = "Hello";

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
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void m3() {
        synchronized ("Hello") {
            System.out.println("m3");
        }
    }

    public static void main(String[] args) {
        DoNotLockString t = new DoNotLockString();
        new Thread(t::m1).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(t::m2).start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(t::m3).start();
    }
}
