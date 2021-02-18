package com.servi.study.leetcode;

public class LeetCode_Offer_07_2 {

    public static void main(String[] args) {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};

        TreeNode root = new LeetCode_Offer_07_2().buildTree(preOrder, inOrder);
        System.out.println(root.toString());
    }

    int preindex = 0;
    int inindex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildSubTree(preorder, inorder, null);
    }


    public TreeNode buildSubTree(int[] preorder, int[] inorder, TreeNode last) {
        if (last != null && inorder[inindex] == last.val || preindex == preorder.length) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preindex++]);
        root.left = buildSubTree(preorder, inorder, root);
        inindex++;
        root.right = buildSubTree(preorder, inorder, last);
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
