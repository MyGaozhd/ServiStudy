package com.servi.study.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "()" 输出：true 示例 2：
 * 
 * 输入：s = "()[]{}" 输出：true 示例 3：
 * 
 * 输入：s = "(]" 输出：false 示例 4：
 * 
 * 输入：s = "([)]" 输出：false 示例 5：
 * 
 * 输入：s = "{[]}" 输出：true
 *
 */
public class LeetCode_20 {

	public static void main(String[] args) {

		System.out.print(new LeetCode_20().isValid("["));
	}

	/**
	 * 
	 * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.22% 的用户 内存消耗： 36.6 MB , 在所有 Java 提交中击败了
	 * 46.21% 的用户
	 *
	 */
	public boolean isValid(String s) {

		int n = s.length();
		if (n % 2 == 1) {
			return false;
		}

		Stack<Character> stack = new Stack<>();
		char[] c = s.toCharArray();

		for (int i = 0; i < c.length; i++) {
			if ('(' == c[i]) {
				stack.push(')');
			} else if ('[' == c[i]) {
				stack.push(']');
			} else if ('{' == c[i]) {
				stack.push('}');
			} else {
				if (stack.isEmpty() || c[i] != stack.pop()) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	/**
	 * 
	 * 执行用时： 2 ms , 在所有 Java 提交中击败了 74.23% 的用户 内存消耗： 36.6 MB , 在所有 Java 提交中击败了
	 * 52.70% 的用户
	 */
	public boolean isValid2(String s) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char k = s.charAt(i);
			if ('(' == k) {
				stack.push(')');
			} else if ('[' == k) {
				stack.push(']');
			} else if ('{' == k) {
				stack.push('}');
			} else {
				if (stack.isEmpty() || k != stack.pop()) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	/**
	 * 
	 * @Description TODO
	 *
	 * @param s
	 * @return
	 */
	public boolean isValid3(String s) {

		while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
			if (s.contains("()")) {
				s = s.replace("()", "");
			}
			if (s.contains("{}")) {
				s = s.replace("{}", "");
			}
			if (s.contains("[]")) {
				s = s.replace("[]", "");
			}
		}
		return s.length() == 0;
	}

	public boolean isValid4(String s) {

		int n = s.length();
		if (n % 2 == 1) {
			return false;
		}

		Map<Character, Character> pairs = new HashMap<Character, Character>() {

			{
				put(')', '(');
				put(']', '[');
				put('}', '{');
			}
		};
		Deque<Character> stack = new LinkedList<Character>();
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (pairs.containsKey(ch)) {
				if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
					return false;
				}
				stack.pop();
			} else {
				stack.push(ch);
			}
		}
		return stack.isEmpty();
	}

	/**
	 * 
	 * 显示详情 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.5 MB , 在所有 Java
	 * 提交中击败了 69.96% 的用户
	 */
	public boolean isValid5(String s) {

		char[] chars = s.toCharArray();

		char[] stack = new char[chars.length];

		int p = 0;

		for (int i = 0; i < chars.length; i++) {

			char c = chars[i];

			if ((c == '(') || (c == '{') || c == '[') {
				stack[p++] = c;
			} else {
				if (p == 0) {
					return false;
				}
				char k = stack[--p];
				if (k == '(' && c == ')') {

				} else if (k == '[' && c == ']') {

				} else if (k == '{' && c == '}') {

				} else {
					return false;
				}
			}

		}

		return p == 0;

	}

}
