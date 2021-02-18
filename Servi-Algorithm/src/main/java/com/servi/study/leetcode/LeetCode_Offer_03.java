package com.servi.study.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class LeetCode_Offer_03 {

    public static void main(String[] args) {
        System.out.println(new LeetCode_Offer_03().findRepeatNumber(new int[]{0, 1, 2, 3, 4, 4}));
    }

    public int findRepeatNumber(int[] nums) {
        int[] n = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (n[nums[i]] == 0) {
                n[nums[i]] = n[nums[i]] + 1;
            } else {
                return nums[i];
            }
        }
        return nums[0];
    }

    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    //方法二：原地交换，萝卜
    public int findRepeatNumber2(int[] nums) {
        int tmp;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i) {
                tmp = nums[i];
                if (nums[tmp] == tmp)
                    return tmp;
                else {
                    nums[tmp] = tmp;
                    nums[i] = i;
                }
            }
            i++;
        }
        return -1;
    }
}
