package com.servi.study.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class LeetCode_Offer_06 {

    public static void main(String[] args) {

    }

    public int[] reversePrint(ListNode head) {
        if (head == null)
            return new int[]{};

        List<Integer> list = new LinkedList<>();
        reversePrint(head, list);
        int[] result = new int[list.size()];
        int i = 0;
        for (Integer item : list) {
            result[i++] = item;
        }

        return result;
    }

    public void reversePrint(ListNode node, List<Integer> list) {
        if (node.next != null) {
            reversePrint(node.next, list);
        }
        list.add(node.val);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
