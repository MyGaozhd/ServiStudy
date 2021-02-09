package com.servi.study.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author servi
 * @date 2021/2/9
 */
public class LeetCode_169 {

    public static void main(String[] args) {
        System.out.println(new LeetCode_169().majorityElement3(new int[]{1, 1, 2}));
    }

    public int majorityElement(int[] nums) {

        Map<Integer, Integer> m = new HashMap<>();
        int max = 0;
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = m.getOrDefault(nums[i], 0) + 1;
            m.put(nums[i], tmp);
            if (tmp > max) {
                max = tmp;
                num = nums[i];
            }
        }

        return num;
    }

    public int majorityElement2(int[] nums) {

        Arrays.parallelSort(nums);

        return nums[nums.length / 2];
    }

    public int majorityElement3(int[] nums) {

        int more = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (more == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    more = nums[i];
                    count = 1;
                }
            }
        }

        return more;
    }
}
