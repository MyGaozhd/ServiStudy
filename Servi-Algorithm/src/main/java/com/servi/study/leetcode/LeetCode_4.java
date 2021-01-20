package com.servi.study.leetcode;

/**
 * 4. 寻找两个正序数组的中位数 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2] 输出：2.00000 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4] 输出：2.50000 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) /
 * 2 = 2.5
 *
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0] 输出：0.00000
 *
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1] 输出：1.00000
 *
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = [] 输出：2.00000
 *
 *
 * 提示：
 *
 * nums1.length == m nums2.length == n 0 <= m <= 1000 0 <= n <= 1000 1 <= m + n
 * * <= 2000 -106 <= nums1[i], nums2[i] <= 106
 */
public class LeetCode_4 {

	public static void main(String[] args) {

//		int[] a = new int[] { 1, 2, 3, 4 };
//
//		int[] b = new int[] { 0, 5 };

		int[] a = new int[] { 1, 2 };

		int[] b = new int[] { 3, 4 };

		System.out.print(new LeetCode_4().findMedianSortedArrays(a, b));
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int[] merge = merge(nums1, nums2);

		if ((merge.length % 2) == 0) {
			int n = merge.length / 2;
			return ((double) (merge[n] + merge[n - 1])) / 2;
		} else {
			return merge[merge.length / 2];
		}
	}

	public int[] merge(int[] nums1, int[] nums2) {

		int[] r = new int[nums1.length + nums2.length];

		int i = 0;
		int j = 0;
		int c = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				r[c] = nums1[i];
				i++;
			} else {
				r[c] = nums2[j];
				j++;
			}
			c++;
		}

		while (i < nums1.length) {
			r[c] = nums1[i];
			i++;
			c++;
		}

		while (j < nums2.length) {
			r[c] = nums2[j];
			j++;
			c++;
		}

		return r;
	}
}
