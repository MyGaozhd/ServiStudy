package com.servi.study.leetcode;

/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * 提示：
 * <p>
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 */
public class LeetCode_50 {

    public static void main(String[] args) {

        System.out.println(new LeetCode_50().myPow(2, 4));
    }

    public double myPow(double x, int n) {

        if (n == 0) {
            return 1.0;
        }

        if (x == 0) {
            return 0.0;
        }

        return n >= 0 ? fastPow(x, n) : 1.0 / fastPow(x, n);
    }

    public double fastPow(double x, int n) {
        if (n == 1) {
            return x;
        }

        double result = fastPow(x, n / 2);

        return n % 2 == 0 ? result * result : result * result * x;
    }
}
