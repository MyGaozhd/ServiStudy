package com.servi.study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_22 {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(Arrays.toString(new LeetCode_22().generateParenthesis(12).toArray(new String[0])));
        System.out.println(System.currentTimeMillis());
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesis(0, 0, n, list, "");
        return list;
    }

    public void generateParenthesis(int left, int right, int n, List<String> list, String s) {

        if (left == n && right == n) {
            list.add(s);
        }
        if (left < n)
            generateParenthesis(left + 1, right, n, list, s + "(");
        if (left > right)
            generateParenthesis(left, right + 1, n, list, s + ")");
    }
}
