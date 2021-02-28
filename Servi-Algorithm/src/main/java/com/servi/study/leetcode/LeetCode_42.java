package com.servi.study.leetcode;

/**
 * 数组{1,4,-7,5,2,-1,2,-4,3}的最大连续子数组为{5,2,-1,2}
 * 输出该数组的“连续子数组的最大和
 */
public class LeetCode_42 {

    public static void main(String[] args) {
        System.out.println(new LeetCode_42().max(new int[]{1, 2, -2}));
    }

    public int max(int[] nums) {

        int max = -Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;
            for (int j = i; j < nums.length; j++) {
                tmp += nums[j];
                if (tmp > max) {
                    max = tmp;
                }
            }
        }

        return max;
    }
}
