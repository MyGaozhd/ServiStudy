package com.servi.study.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_1 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 13, 14};
        System.out.println(Arrays.toString(new LeetCode_1().twoSum1(nums, 9)));
    }

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == a) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (m.containsKey(a)) {
                return new int[]{m.get(a), i};
            }
            m.put(nums[i], i);
        }

        return new int[]{};
    }
}
