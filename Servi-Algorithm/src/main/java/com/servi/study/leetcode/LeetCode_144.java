package com.servi.study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 */
public class LeetCode_144 {

    public static void main(String[] args) {

        TreeNode node0 = new TreeNode(0);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1, node0, node2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, node1, node4);

        TreeNode node9 = new TreeNode(9);
        TreeNode node8 = new TreeNode(8, null, node9);
        TreeNode node6 = new TreeNode(6);

        TreeNode node7 = new TreeNode(7, node6, node8);

        TreeNode node5 = new TreeNode(5, node3, node7);

        System.out.print(Arrays.toString(preorderTraversal(node5).toArray()));
       
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;
    }

    public static void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
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
