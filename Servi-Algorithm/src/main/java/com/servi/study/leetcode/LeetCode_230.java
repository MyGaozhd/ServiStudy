package com.servi.study.leetcode;

/**
 * 230. 二叉搜索树中第K小的元素 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明： 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1 3 / \ 1 4 \ 2 输出: 1 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3 5 / \ 3 6 / \ 2 4 / 1 输出: 3 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 */
public class LeetCode_230 {

    private int count;
    private int kth;

    public int kthSmallest(TreeNode root, int k) {

        kthSmallest1(root.left, k);
        return kth;
    }

    public void kthSmallest1(TreeNode root, int k) {

        if (root == null) {
            return;
        }

        kthSmallest1(root.left, k);
        count++;
        if (count == k) {
            kth = root.val;
            return;
        } else {
            kthSmallest1(root.right, k);
        }
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {

            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {

            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
