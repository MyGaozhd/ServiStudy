package com.servi.study.leetcode;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 */
public class LeetCode_84 {

    public static void main(String[] args) {
        System.out.println(new LeetCode_84().largestRectangleArea(new int[]{2, 1, 5}));
    }

    public int largestRectangleArea(int[] heights) {

        int maxArea = -1;
        for (int i = 0; i <= heights.length - 1; i++) {
            int h = heights[i];
            for (int j = i; j <= heights.length - 1; j++) {
                if (h > heights[j]) {
                    h = heights[j];
                }
                if (maxArea < ((j - i + 1) * h)) {
                    maxArea = ((j - i + 1) * h);
                    System.out.println("maxArea=" + maxArea);
                }
            }
        }

        return maxArea;
    }
}
