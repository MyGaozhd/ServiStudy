package com.servi.study.leetcode;

/**
 * 35. 搜索插入位置 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5 输出: 2 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2 输出: 1 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7 输出: 4 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0 输出: 0
 */
public class LeetCode_35 {

    public static void main(String[] args) {

        int[] a = new int[]{1, 3, 6};
        System.out.print(new LeetCode_35().searchInsert(a, 0));
    }

    public int searchInsert(int[] nums, int target) {

        return searchInsert(nums, target, 0, nums.length - 1);
    }

    public int searchInsert(int[] nums, int target, int left, int right) {

        if (left < 0) {
            return 0;
        }

        if (right > nums.length - 1) {
            return nums.length;
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            if (mid == 0) {
                return 0;
            } else if (nums[mid - 1] == target) {
                return mid - 1;
            } else if (nums[mid - 1] < target) {
                return mid;
            } else if (nums[mid - 1] > target) {
                return searchInsert(nums, target, left, mid - 1);
            }
        } else if (nums[mid] < target) {
            if (mid == nums.length - 1) {
                return nums.length;
            } else if (nums[mid + 1] == target) {
                return mid + 1;
            } else if (nums[mid + 1] < target) {
                return searchInsert(nums, target, mid + 1, right);
            } else if (nums[mid + 1] > target) {
                return mid + 1;
            }
        }

        return -1;
    }
}
