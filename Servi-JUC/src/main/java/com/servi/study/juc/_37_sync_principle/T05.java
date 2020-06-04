/**
 * 测试   synchronized static  method 和  synchronized method 方法加锁和  synchronized (this) 对象加锁的 不同
 */
package com.servi.study.juc._37_sync_principle;

import org.openjdk.jol.info.ClassLayout;

public class T05 {

    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(5000);

        //testStatic();
        testMethodAndThis();
    }

    /**
     * 测试 class
     */
    public static void testStatic() {

        Class<Test> clazz = Test.class;
        System.out.println(ClassLayout.parseInstance(clazz).toPrintable());
        new Thread(Test::s).start();
        new Thread(Test::s).start();
        System.out.println(ClassLayout.parseInstance(clazz).toPrintable());
    }

    public static void testMethodAndThis() {
        Test t = new Test();
        System.out.println("new: " + ClassLayout.parseInstance(t).toPrintable());
        new Thread(t::m).start();
        new Thread(t::m).start();

    }

    static class Test {

        public static synchronized void s() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void m() {
            try {
                Thread.sleep(5000);
                System.out.println("m: " + ClassLayout.parseInstance(this).toPrintable());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void n() {
            synchronized (this) {
                try {
                    Thread.sleep(5000);
                    System.out.println("n: " + ClassLayout.parseInstance(this).toPrintable());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
