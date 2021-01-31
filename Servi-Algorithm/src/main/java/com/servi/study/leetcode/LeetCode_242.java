package com.servi.study.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 */
public class LeetCode_242 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_242().isAnagram3("anagram", "nagaram"));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (m.containsKey(s.charAt(i))) {
                m.put(s.charAt(i), m.get(s.charAt(i)) + 1);
            } else {
                m.put(s.charAt(i), 1);
            }

            if (m.containsKey(t.charAt(i))) {
                m.put(t.charAt(i), m.get(t.charAt(i)) - 1);
            } else {
                m.put(t.charAt(i), -1);
            }
        }

        for (Map.Entry<Character, Integer> e : m.entrySet()) {
            if (e.getValue().intValue() != 0) {
                return false;
            } else {
                System.out.println(e.getKey() + ":" + e.getValue());
            }
        }

        return true;
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
            m.put(t.charAt(i), m.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (Map.Entry<Character, Integer> e : m.entrySet()) {
            if (e.getValue().intValue() != 0) {
                return false;
            } else {
                System.out.println(e.getKey() + ":" + e.getValue());
            }
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {
        int[] snums = new int[26];
        int[] tnums = new int[26];
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        for (char aChar : chars) {
            snums[(aChar - 'a')]++;
        }
        for (char c : chart) {
            tnums[(c - 'a')]++;
        }
        for (int i = 0; i < 26; i++) {
            if (snums[i] != tnums[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] snums = new int[26];
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            snums[(chars[i] - 'a')]++;
            snums[(chart[i] - 'a')]--;
        }

        for (int i = 0; i < 26; i++) {
            if (snums[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
