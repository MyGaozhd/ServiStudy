package com.servi.study.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 297. 二叉树的序列化与反序列化
 */
public class LeetCode_297_1 {

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

        LeetCode_297_1 l = new LeetCode_297_1();
        String s = l.serialize(node5);
        System.out.println(s);
        TreeNode n = l.deserialize(s);
        s = l.serialize(n);
        System.out.println(s);
    }

    public String serialize(TreeNode root) {

        StringBuilder s = new StringBuilder();
        doSerialize(root, s);
        return s.deleteCharAt(s.length() - 1).toString();
    }

    public void doSerialize(TreeNode root, StringBuilder s) {

        if (root == null) {
            s.append("~,");
            return;
        }

        s.append(root.val + ",");
        if (root.left == null && root.right == null) {
            s.append("~,~,");
        } else {
            doSerialize(root.left, s);
            doSerialize(root.right, s);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        List<String> l = new LinkedList<String>();
        l.addAll(Arrays.asList(data.split(",")));

        return deserialize(l);
    }

    public TreeNode deserialize(List<String> l) {

        if (l.get(0).equals("~")) {
            l.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(l.get(0)));
        l.remove(0);
        root.left = deserialize(l);
        root.right = deserialize(l);
        return root;
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
