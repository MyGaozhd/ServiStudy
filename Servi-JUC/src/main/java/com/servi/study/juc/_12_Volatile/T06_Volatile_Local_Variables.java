/**
 * 不能 因为局部变量不存在并发问题
 */
package com.servi.study.juc._12_Volatile;

/**
 * Volatile 能否修饰局部变量
 */
public class T06_Volatile_Local_Variables {

    public static void main(String[] args) {
        /*volatile*/ int a;
    }
}
