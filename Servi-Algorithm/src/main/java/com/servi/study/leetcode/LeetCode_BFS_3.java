package com.servi.study.leetcode;

import java.util.*;

/**
 * 广度优先遍历
 * 层序遍历隔层反转顺序
 */
public class LeetCode_BFS_3 {

    /**
     * 5
     * 3      7
     * 1   4  6   8
     * 0  2           9
     *
     * [5, 7, 3, 1, 4, 6, 8, 9, 2, 0]
     */
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

        System.out.print(Arrays.toString(bfs(node5).toArray()));
    }

    public static List<Integer> bfs(TreeNode root) {


        LinkedList<Integer> visited = new LinkedList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            //每次访问一层的数据，并把下一层的数据加入到队列
            if (level % 2 == 0) {
                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();
                    visited.add(curr.val);
                    if (curr.left != null) {
                        queue.add(curr.left);
                    }
                    if (curr.right != null) {
                        queue.add(curr.right);
                    }
                }
            } else {
                int orignalsize = visited.size();
                for (int i = 0; i < size; i++) {
                    visited.add(0);
                }
                for (int i = orignalsize + size - 1; i >= orignalsize; i--) {
                    TreeNode curr = queue.poll();
                    visited.set(i, curr.val);
                    if (curr.left != null) {
                        queue.add(curr.left);
                    }
                    if (curr.right != null) {
                        queue.add(curr.right);
                    }
                }
            }
            level++;
        }

        return visited;
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {

            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {

            this.val = x;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {

            return val + "";
        }

    }
}
