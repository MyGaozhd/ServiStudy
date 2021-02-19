package com.servi.study.leetcode;

/**
 * 剑指 Offer 10-I. 斐波那契数列
 */
public class LeetCode_Offer_10_1 {
    public static void main(String[] args) {
//        System.out.println(new LeetCode_Offer_10_1().fib(5));
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(new LeetCode_Offer_10_1().fib1(43));
        System.out.println(new LeetCode_Offer_10_1().fib1(44));
        System.out.println(new LeetCode_Offer_10_1().fib1(43) + new LeetCode_Offer_10_1().fib1(44));
//        System.out.println(new LeetCode_Offer_10_1().fib2(1000));
    }

    public int fib(int n) {
        if (n <= 1) return n;

        return fib(n - 1) + fib(n - 2);
    }

    public int fib1(int n) {
        if (n < 2) return n;

        int n_1 = 1;
        int n_2 = 0;
        int result = -1;
        for (int i = 2; i <= n; i++) {
            result = n_1 + n_2;
            n_2 = n_1;
            n_1 = result;
        }
        return result;
    }


    public int fib2(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
