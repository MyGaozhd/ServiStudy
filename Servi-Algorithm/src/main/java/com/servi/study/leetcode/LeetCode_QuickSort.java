package com.servi.study.leetcode;

import java.util.Arrays;

/**
 * 快速排序
 */
public class LeetCode_QuickSort {
    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 2, 1, 3, 7, 77};
        new LeetCode_QuickSort().quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = getMid(nums, left, right);
            quickSort(nums, left, mid - 1);
            quickSort(nums, mid + 1, right);
        }

    }

    public int getMid(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (nums[right] > pivot && left < right) {
                right--;
            }
            nums[left] = nums[right];

            while (nums[left] <= pivot && left < right) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
