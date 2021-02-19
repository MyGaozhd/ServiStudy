package com.servi.study.leetcode;

/**
 * 剑指 Offer 10-II. 青蛙跳台阶问题
 */
public class LeetCode_Offer_10_2 {
    public static void main(String[] args) {

    }


    public int numWays(int n) {

        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }

        return numWays(n - 1) + numWays(n - 2);
    }

    public int numWays1(int n) {

        if (n < 2) {
            return 1;
        }
        int n_1 = 1;
        int n_2 = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = n_1 + n_2;
            n_2 = n_1;
            n_1 = result;
        }
        return result;
    }
}
