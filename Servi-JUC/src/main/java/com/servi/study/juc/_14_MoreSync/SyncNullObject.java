/**
 * 锁定 null 对象
 * Exception in thread "Thread-0" Exception in thread "Thread-1" java.lang.NullPointerException
 * at com.servi.study.juc._14_MoreSync.LockNullObject.m2(LockNullObject.java:26)
 * at java.lang.Thread.run(Thread.java:748)
 * java.lang.NullPointerException
 * at com.servi.study.juc._14_MoreSync.LockNullObject.m1(LockNullObject.java:15)
 * at java.lang.Thread.run(Thread.java:748)
 */
package com.servi.study.juc._14_MoreSync;

/**
 * @author servi
 * @date 2020/6/3
 */
public class SyncNullObject {

    private Object o = null;

    public void m1() {
        synchronized (o) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("锁定空对象-m1");
        }
    }

    public void m2() {
        synchronized (o) {
            System.out.println("锁定空对象-m2");
        }
    }

    public static void main(String[] args) {
        SyncNullObject lock = new SyncNullObject();
        new Thread(lock::m1).start();

        new Thread(lock::m2).start();
    }
}
