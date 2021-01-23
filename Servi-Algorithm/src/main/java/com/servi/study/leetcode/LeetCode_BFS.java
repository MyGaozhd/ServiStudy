package com.servi.study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  广度优先遍历
 */
public class LeetCode_BFS {

	/**
	 *     	 	 5
	 *   	  3      7
	 * 		1   4  6   8
	 *    0  2           9
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

		List<Integer> visited = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode curr = queue.remove();
			visited.add(curr.val);
			if (curr.left != null) {
				queue.add(curr.left);
			}
			if (curr.right != null) {
				queue.add(curr.right);
			}
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
