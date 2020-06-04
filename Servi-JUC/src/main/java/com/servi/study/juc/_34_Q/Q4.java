package com.servi.study.juc._34_Q;

/**
 * @author servi
 * @date 2020/6/4
 */
public class Q4 {
    private static volatile int count = 0;

    private void add() {
        int i = 0;
        while (i++ < 10000) {
            count = 2;
        }
    }
}
