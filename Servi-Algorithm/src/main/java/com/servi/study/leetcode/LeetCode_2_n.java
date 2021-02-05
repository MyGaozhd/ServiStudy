package com.servi.study.leetcode;

/**
 * @author servi
 * @date 2021/2/5
 * 2的n次幂的累加和
 */
public class LeetCode_2_n {
    public static void main(String[] args) {

        System.out.println(System.currentTimeMillis());
        System.out.println(m6(30));
        System.out.println(System.currentTimeMillis());
        System.out.println(m7(30));
        System.out.println(System.currentTimeMillis());
        System.out.println(m8(30));
        System.out.println(System.currentTimeMillis());
    }

    //2的31次幂的累加和
    public static int m6(int n) {
        if (n == 0) {
            return 1;
        }

        int tmp = 1;
        int value = 1;
        for (int i = 1; i <= n; i++) {
            tmp *= 2;
            value += tmp;
        }
        return value;
    }

    //2的31次幂的累加和
    public static int m7(int n) {
        if (n == 0) {
            return 1;
        }

        int tmp = 1;
        int value = tmp << n;
        System.out.println("value=" + value + ",value=" + Integer.toBinaryString(value));
        tmp = ~value;
        System.out.println("tmp=" + tmp + ",tmp=" + Integer.toBinaryString(tmp));
        tmp = ~(tmp + 1);
        System.out.println("tmp=" + tmp + ",tmp=" + Integer.toBinaryString(tmp));
        return value ^ tmp;
    }

    //2的30次幂的累加和
    public static int m8(int n) {
        if (n == 0) {
            return 1;
        }

        int value = 1 << n;
        return value ^ (value - 1);
    }
}
