package com.servi.study.leetcode;

/**
 * 240. 搜索二维矩阵 II 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。 每列的元素从上到下升序排列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix =
 * [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
 * target = 5 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：matrix =
 * [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
 * target = 20 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length n == matrix[i].length 1 <= n, m <= 300 -109 <= matix[i][j]
 * <= 109 每行的所有元素从左到右升序排列 每列的所有元素从上到下升序排列 -109 <= target <= 109
 */
public class LeetCode_240 {

    public static void main(String[] args) {

        int[][] a = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

        System.out.print(new LeetCode_240().searchMatrix(a, 5));
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            int[] tmp = matrix[i];
            if (tmp[0] <= target && tmp[tmp.length - 1] >= target) {
                if (binarySearch(tmp, target) != -1) {
                    return true;
                }
            }
        }
        return false;
    }

    int binarySearch(int[] nums, int target) {

        return binarySearch(nums, target, 0, nums.length - 1);
    }

    int binarySearch(int[] nums, int target, int left, int right) {

        if (left == right) {
            if (nums[left] == target) {
                return left;
            } else {
                return -1;
            }
        }

        if (left > right || right < left) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        int tmp = nums[mid];

        if (tmp == target) {
            return mid;
        } else if (tmp > target) {
            return binarySearch(nums, target, left, mid - 1);
        } else if (tmp < target) {
            return binarySearch(nums, target, mid + 1, right);
        }

        return -1;
    }
}
