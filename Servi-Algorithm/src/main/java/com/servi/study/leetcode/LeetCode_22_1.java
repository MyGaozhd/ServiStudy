package com.servi.study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_22_1 {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(Arrays.toString(new LeetCode_22().generateParenthesis(10).toArray(new String[0])));
        System.out.println(System.currentTimeMillis());
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        char[] candidate = new char[n * 2];
        generate(result, candidate, 0, 0, 0, n);
        return result;
    }

    public void generate(List<String> result, char[] candidate, int pos, int open, int close, int n) {
        if (pos == candidate.length) {
            result.add(new String(candidate));
            return;
        }

        if (open < n) {
            candidate[pos] = '(';
            generate(result, candidate, pos + 1, open + 1, close, n);
        }
        if (close < open) {
            candidate[pos] = ')';
            generate(result, candidate, pos + 1, open, close + 1, n);
        }

    }
}
