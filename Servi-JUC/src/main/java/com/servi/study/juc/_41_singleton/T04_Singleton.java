package com.servi.study.juc._41_singleton;

/**
 * 4、双检锁/双重校验锁（DCL，即 double-checked locking）
 * 这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 */
public class T04_Singleton {

    private static volatile T04_Singleton instance = null;

    private T04_Singleton() {
    }

    public static T04_Singleton getInstance() {
        if (instance == null) {
            synchronized (T04_Singleton.class) {
                if (instance == null) {
                    instance = new T04_Singleton();
                }
            }
        }
        return instance;
    }
}
