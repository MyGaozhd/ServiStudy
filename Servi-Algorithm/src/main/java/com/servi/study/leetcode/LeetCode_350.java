package com.servi.study.leetcode;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_350 {

    public static void main(String[] args) {
//        int[] a = new int[]{4,9,5};
//        int[] b = new int[]{9,4,9,8,4};
        int[] a = new int[]{1, 2};
        int[] b = new int[]{1, 1};
        System.out.println(ArrayUtils.toString(new LeetCode_350().intersect(a, b)));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] shorts = nums1.length < nums2.length ? nums1 : nums2;
        Map<Integer, Integer> counts = new HashMap();

        for (int i = 0; i < shorts.length; i++) {
            if (counts.containsKey(shorts[i])) {
                Integer count = counts.get(shorts[i]) + 1;
                counts.put(shorts[i], count);
            } else {
                counts.put(shorts[i], 1);
            }
        }

        int[] longs = nums1.length < nums2.length ? nums2 : nums1;
        ArrayList<Integer> anums = new ArrayList<>();
        for (int i = 0; i < longs.length; i++) {
            if (counts.containsKey(longs[i]) && counts.get(longs[i]) > 0) {
                anums.add(longs[i]);
                Integer count = counts.get(longs[i]) - 1;
                counts.put(longs[i], count);
            }
        }
        int[] nums = new int[anums.size()];

        for (int i = 0; i < anums.size(); i++) {
            nums[i] = anums.get(i);
        }

        return nums;
    }
}
