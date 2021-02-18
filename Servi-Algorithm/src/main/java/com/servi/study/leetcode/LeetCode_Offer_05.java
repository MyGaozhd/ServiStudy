package com.servi.study.leetcode;

/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class LeetCode_Offer_05 {

    public static void main(String[] args) {

        System.out.println(new LeetCode_Offer_05().replaceSpace1("we are happy."));
        System.out.println(new LeetCode_Offer_05().replaceSpace2("we are happy."));
    }

    public String replaceSpace1(String s) {
        int orignalLength = s.length();
        char[] a = new char[orignalLength * 3];

        char[] orignalA = s.toCharArray();

        int result = 0;
        for (int i = 0; i < orignalLength; i++) {
            if (orignalA[i] == ' ') {
                a[result++] = '%';
                a[result++] = '2';
                a[result++] = '0';
            } else {
                a[result++] = orignalA[i];
            }
        }
        return new String(a, 0, result);
    }

    public String replaceSpace2(String s) {
        int orignalLength = s.length();
        char[] orignalArray = s.toCharArray();
        int newLength = orignalLength;
        for (int i = 0; i < orignalLength; i++) {
            if (orignalArray[i] == ' ') {
                newLength = newLength + 2;
            }
        }
        char[] newArray = new char[newLength];
        newLength--;
        orignalLength--;
        while (orignalLength >= 0) {

            if (orignalArray[orignalLength] == ' ') {
                newArray[newLength--] = '0';
                newArray[newLength--] = '2';
                newArray[newLength--] = '%';
            } else {
                newArray[newLength--] = orignalArray[orignalLength];
            }
            orignalLength--;
        }
        return new String(newArray);
    }
}
