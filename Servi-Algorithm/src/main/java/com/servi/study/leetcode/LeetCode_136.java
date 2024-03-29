package com.servi.study.leetcode;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * 通过次数311,691提交次数441,755
 */
public class LeetCode_136 {

    public static void main(String[] args) {
        System.out.println(new LeetCode_136().singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    public int singleNumber(int[] nums) {

        int single = nums[0];

        for (int i = 1; i < nums.length; i++) {
            single ^= nums[i];
        }

        return single;
    }
}
