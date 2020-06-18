package com.servi.study.juc._15_AtomicXXX;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author servi
 */
public class T05_AtomicReferenceFieldUpdater {

    public static void main(String[] args) {

        AtomicReferenceFieldUpdater updater = AtomicReferenceFieldUpdater.newUpdater(T.class, String.class, "a");

        T t = new T();
        t.a = "a";
        System.out.println(updater.compareAndSet(t,"a","b"));
        System.out.println(t.a);

    }

    static class T {
        volatile String a;
    }
}
