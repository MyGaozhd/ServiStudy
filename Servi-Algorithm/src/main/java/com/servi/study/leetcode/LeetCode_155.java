package com.servi.study.leetcode;

import java.util.Deque;
import java.util.LinkedList;


/**
 * 155. 最小栈 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。 pop() —— 删除栈顶的元素。 top() —— 获取栈顶元素。 getMin() ——
 * 检索栈中的最小元素。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入： ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出： [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释： MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0);
 * minStack.push(-3); minStack.getMin(); --> 返回 -3. minStack.pop();
 * minStack.top(); --> 返回 0. minStack.getMin(); --> 返回 -2.
 * <p>
 * <p>
 * 提示：
 * <p>
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 */
public class LeetCode_155 {

    static class MinStack {

        Deque<Integer> xStack;
        Deque<Integer> minStack;

        public MinStack() {

            xStack = new LinkedList<Integer>();
            minStack = new LinkedList<Integer>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {

            xStack.push(x);
            minStack.push(Math.min(minStack.peek(), x));
        }

        public void pop() {

            xStack.pop();
            minStack.pop();
        }

        public int top() {

            return xStack.peek();
        }

        public int getMin() {

            return minStack.peek();
        }
    }
}
