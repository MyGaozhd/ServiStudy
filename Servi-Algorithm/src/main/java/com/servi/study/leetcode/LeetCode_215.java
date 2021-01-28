package com.servi.study.leetcode;

/**
 *
 * 215. 数组中的第K个最大元素 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k
 * 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2 输出: 5 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4 输出: 4 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 */
public class LeetCode_215 {

	public static void main(String[] args) {

//		int[] a = new int[] { 5, 4, 2, 1, 3, 7, 77 };
//		int[] a = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int[] a = new int[] { 1 };

//		new LeetCode_215().findKthLargest(a, 3);

//		new LeetCode_215().quickSelect(a, 0, a.length - 1, 2);
		System.out.println(new LeetCode_215().findKthLargest(a, 1));
//		System.out.println(Arrays.toString(a));
	}

	public int findKthLargest(int[] nums, int k) {

		return quickSelect(nums, 0, nums.length - 1, k - 1);
	}

	public int quickSelect(int[] nums, int left, int right, int k) {

		if (left < right) {
			int mid = mid(nums, left, right);
			if (mid == k) {
				return nums[mid];
			} else if (mid > k) {
				return quickSelect(nums, left, mid - 1, k);
			} else if (mid < k) {
				return quickSelect(nums, mid + 1, right, k);
			}
		} else if (left <= right && left == k) {
			return nums[k];
		}
		return -1;
	}

	public int mid(int[] nums, int left, int right) {

		int pivot = nums[left];

		while (left < right) {
			while (nums[right] <= pivot && left < right) {
				right--;
			}

			nums[left] = nums[right];

			while (nums[left] >= pivot && left < right) {
				left++;
			}
			nums[right] = nums[left];
		}

		nums[left] = pivot;
		return left;
	}
}
