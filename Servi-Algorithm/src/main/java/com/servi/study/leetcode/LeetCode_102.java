package com.servi.study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class LeetCode_102 {

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		levelOrder(root, 0, list);
		return list;
	}

	public void levelOrder(TreeNode root, int level, List<List<Integer>> list) {

		if (list.size() == level && root != null) {
			list.add(new ArrayList<Integer>());
		}

		if (root == null) {
			return;
		}
		list.get(level).add(root.val);

		if (root.left != null) {
			levelOrder(root.left, level + 1, list);
		}

		if (root.right != null) {
			levelOrder(root.right, level + 1, list);
		}
	}

	public class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {

			val = x;
		}
	}
}
