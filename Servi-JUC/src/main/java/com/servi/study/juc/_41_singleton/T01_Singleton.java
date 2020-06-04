package com.servi.study.juc._41_singleton;

/**
 * 1、懒汉式，线程不安全
 * 这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。
 * 因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
 * 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
 */
public class T01_Singleton {

    private static T01_Singleton instance = null;

    private T01_Singleton() {

    }

    public static T01_Singleton getInstance() {
        if (instance == null) {
            instance = new T01_Singleton();
        }
        return instance;
    }
}
