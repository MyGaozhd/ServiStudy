package com.servi.study.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.10. 主要元素 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,5,9,5,9,5,5,5] 输出：5
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：[3,2] 输出：-1
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：[2,2,1,1,1,2,2] 输出：2
 */
public class LeetCode_17_10 {
    public static void main(String[] args) {

        int[] a = new int[]{2, 7, 3, 5, 5};
        System.out.print(new LeetCode_17_10().majorityElement(a));
    }


    public int majorityElement(int[] nums) {

        int max = 0;
        int k = -1;
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i])) {
                m.put(nums[i], m.get(nums[i]) + 1);
            } else {
                m.put(nums[i], 1);
            }

            if (m.get(nums[i]) > max) {
                max = m.get(nums[i]);
                k = nums[i];
            }
        }

        return max >= ((nums.length + 1) / 2) ? k : -1;
    }
}
