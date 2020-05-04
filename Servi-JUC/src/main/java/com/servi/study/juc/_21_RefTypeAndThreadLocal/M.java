package com.servi.study.juc._21_RefTypeAndThreadLocal;

public class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
