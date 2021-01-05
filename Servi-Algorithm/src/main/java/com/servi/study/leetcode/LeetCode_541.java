package com.servi.study.leetcode;

/**
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *  
 * <p>
 * 提示：
 * <p>
 * 该字符串只包含小写英文字母。
 * 给定字符串的长度和 k 在 [1, 10000] 范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_541 {

    public static void main(String[] args) {
        System.out.println(LeetCode_541.reverseStr4("abcdefg", 2));
        System.out.println(LeetCode_541.reverseStr3("abcdefg", 2));
//        System.out.println(LeetCode_541.reverseStr2("abcd", 4));
    }

    public static String reverseStr2(String s, int k) {

        if (s == null || k <= 0) {
            return s;
        }
        char[] cs = s.toCharArray();

        for (int i = 0; i < cs.length; i = i + 2 * k) {
            int t = 0;
            if (cs.length - i < k) {
                t = cs.length - 1;
            }

            if (cs.length - i >= k) {
                t = i + k - 1;
            }

            for (int h = i; h < t; h++, t--) {
                char tem = cs[h];
                cs[h] = cs[t];
                cs[t] = tem;
            }
        }

        return new String(cs);
    }


    public static String reverseStr3(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start;
            int j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char temp = a[i];
                a[i++] = a[j];
                a[j--] = temp;


            }
        }
        return new String(a);
    }


    public static String reverseStr4(String s, int k) {
        char[] arr = s.toCharArray();
        int start = 0;
        while (start < arr.length - 1) {
            int begin = start;
            reverseK(arr, begin, k);
            start += 2 * k;
        }

        return new String(arr);
    }

    private static void reverseK(char[] array, int start, int k) {
        int end = start + k - 1;
        if (end <= array.length - 1) {
            while (start < end) {
                char temp = array[start];
                array[start++] = array[end];
                array[end--] = temp;
            }
        } else {//end > array.length-1 && end < array.length-1+k
            int last = array.length - 1;
            while (start < last) {
                char temp = array[start];
                array[start++] = array[last];
                array[last--] = temp;
            }
        }

    }

}
