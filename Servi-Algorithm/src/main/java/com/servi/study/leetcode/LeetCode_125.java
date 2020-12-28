package com.servi.study.leetcode;

import org.springframework.util.StringUtils;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_125 {

    public static void main(String[] args) {

        String a = "A man, a plan, a canal: Panama";
//        char[] ss = a.toCharArray();
//        for (int i = 0; i < ss.length; i++) {
//            System.out.println(Character.isLetterOrDigit(ss[i]));
//        }
//        String s = "123";
//        System.out.println(Character.toLowerCase(s.toCharArray()[0]));

        System.out.println(LeetCode_125.isPalindrome(a));
    }

    public static boolean isPalindrome(String s) {

        if (s == null) {
            return false;
        }
        char[] c = s.toCharArray();
        for (int i = 0, j = c.length - 1; i < j; ) {
            if (!Character.isLetterOrDigit(c[i])) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(c[j])) {
                j--;
                continue;
            }
            if (Character.toLowerCase(c[i]) != Character.toLowerCase(c[j])) {
                return false;
            } else {
                i++;
                j--;
            }
        }

        return true;
    }
}
