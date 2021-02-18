package com.servi.study.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_Offer_07 {

    public static void main(String[] args) {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};

        TreeNode root = new LeetCode_Offer_07().buildTree(preOrder, inOrder);
        System.out.println(root.toString());
    }

    Map<Integer, Integer> i_map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            i_map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int p_left, int p_right, int i_left, int i_right) {

        if (p_left >= preorder.length || i_left >= inorder.length) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[p_left]);

        if (i_left < i_map.get(preorder[p_left])) {
            root.left = buildTree(preorder, inorder,
                    p_left + 1,
                    p_left + 1 + (i_map.get(preorder[p_left]) - i_left - 1),
                    i_left,
                    i_map.get(preorder[p_left]) - 1);
        }

        if (i_right > i_map.get(preorder[p_left])) {
            root.right = buildTree(preorder, inorder,
                    p_left + 1 + (i_map.get(preorder[p_left]) - i_left - 1) + 1,
                    preorder.length - 1,
                    i_map.get(preorder[p_left]) + 1,
                    i_right);
        }
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + (left == null ? "" : "," + left.toString()) + (right == null ? "" : "," + right.toString());
        }
    }
}
