package com.servi.study.leetcode;

/**
 * @author servi
 * @date 2021/2/3
 */
public class LeetCode_ChangeIntValue {

    public static void main(String[] args) {
        m1();
        m2();
        m3();
    }

    //引入第三方变量
    public static void m1() {
        int a = 33;
        int b = 44;

        int c = a;
        a = b;
        b = c;
        System.out.println("m1-> a:" + a + ",b:" + b);
    }

    public static void m2() {
        int a = 33;
        int b = 44;

        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("m2-> a:" + a + ",b:" + b);
    }

    public static void m3() {
        int a = 33;
        int b = 44;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("m3-> a:" + a + ",b:" + b);
    }
}
