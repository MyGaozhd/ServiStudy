package com.servi.study.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 */
public class LeetCode_Offer_09 {


    class CQueue {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();

        public CQueue() {

        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.isEmpty() ? -1 : (int) stack2.pop();
        }
    }

    class CQueue1 {
        Deque stack1 = new LinkedList();
        Deque stack2 = new LinkedList();

        public CQueue1() {

        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                if (stack1.isEmpty()) {
                    return -1;
                }
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return (int) stack2.pop();
        }
    }
}
