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
public class LeetCode_240_2 {

    public static void main(String[] args) {

//		int[][] a = new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
//				{ 18, 21, 23, 26, 30 } };

        int[][] a = new int[][]{{-5}};

        System.out.print(new LeetCode_240().searchMatrix(a, -10));
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int i = matrix.length - 1;
        int j = 0;

        while (i >= 0) {
            int tmp = matrix[i][j];
            if (tmp == target) {
                return true;
            } else if (tmp > target) {
                i--;
            } else if (tmp < target) {
                j++;
            }

            if (j >= matrix[0].length) {
                return false;
            }
        }

        return false;
    }
}
