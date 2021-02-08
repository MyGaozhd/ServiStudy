package com.servi.study.leetcode;

import com.servi.study.json.IJsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class LeetCode_78 {

    public static void main(String[] args) {
        System.out.println(IJsonUtil.toJson(new LeetCode_78().subsets(new int[]{1, 2, 3})));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        subsets(nums, list, new ArrayList<>(), 0);
        return list;
    }

    public void subsets(int[] nums, List<List<Integer>> list, List<Integer> sub, int index) {

        if (index == nums.length) {
            list.add(sub);
            return;
        }
        subsets(nums, list, new ArrayList<>(sub), index+1);
        sub.add(nums[index]);
        subsets(nums, list, new ArrayList<>(sub), index+1);
    }
}
