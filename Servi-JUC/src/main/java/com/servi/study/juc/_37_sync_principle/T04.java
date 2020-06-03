/**
 *  0 aload_0
 *  1 getfield #3 <com/servi/study/juc/_37_sync_principle/T04.o>
 *  4 dup
 *  5 astore_1
 *  6 monitorenter
 *  7 aload_1
 *  8 monitorexit
 *  9 goto 17 (+8)
 * 12 astore_2
 * 13 aload_1
 * 14 monitorexit
 * 15 aload_2
 * 16 athrow
 * 17 return
 */
package com.servi.study.juc._37_sync_principle;


public class T04 {

    private Object o = new Object();

    public void m1() {
        synchronized (o) {
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        T04 lock = new T04();
        new Thread(lock::m1).start();
    }
}
