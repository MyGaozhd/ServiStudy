package com.servi.study.juc._15_AtomicXXX;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author servi
 */
public class T04_AtomicReference {

    public static void main(String[] args) {
        T t = new T();
        t.a = "123";
        System.out.println(t);
        AtomicReference<T> at = new AtomicReference<>(t);

        Boolean b = at.compareAndSet(t, new T());
        System.out.println(b);

        System.out.println(at.get());
    }


    static class T {
        String a;
    }
}
