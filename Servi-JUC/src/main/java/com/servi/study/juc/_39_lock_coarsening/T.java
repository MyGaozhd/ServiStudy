/**
 * 锁粗话
 */
package com.servi.study.juc._39_lock_coarsening;

public class T {
    private Object o = new Object();

    public void sync() {
        for (int i = 0; i < 100000; i++) {
            synchronized (o) {

            }
        }
    }
}
