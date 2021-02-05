package com.servi.study.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 *
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class LeetCode_Offer32 {
    /**
     * 3
     * 9      20
     * 1  2      7
     */
    public static void main(String[] args) {
        TreeNode node20 = new TreeNode(20);

        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        node20.left = node5;
        node20.right = node7;

        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);

        node3.left = node9;
        node3.right = node20;

        List<List<Integer>> list = levelOrder(node3);

        levelOrder(node3);

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            if (level % 2 == 0) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    tmp.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            } else {
                List<TreeNode> tmpNodes = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    tmpNodes.add(node);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }

                for (int i = tmpNodes.size() - 1; i >= 0; i--) {
                    tmp.add(tmpNodes.get(i).val);
                }
            }
            list.add(tmp);
            level++;
        }
        return list;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
