/**
 * java -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly
 * lock cmpxchg 指令
 * 热点代码的实现
 */
package com.servi.study.juc._40_hotcode;

public class T {
    public static volatile int i = 0;

    public static void main(String[] args) {
        for (int j = 0; j < 1000000; j++) {
            m();
            n();
        }
    }

    public static synchronized void m() {
    }

    public static void n() {
        i = 1;
    }
}
