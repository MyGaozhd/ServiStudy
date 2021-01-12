package com.servi.study.leetcode;

import com.servi.study.json.IJsonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 * <p>
 * 实现 Solution class:
 * <p>
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *  
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * 输出
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 * <p>
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * -106 <= nums[i] <= 106
 * nums 中的所有元素都是 唯一的
 * 最多可以调用 5 * 104 次 reset 和 shuffle
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_384 {

    public static void main(String[] args) {
        Solution_1 s = new Solution_1(new int[]{1, 2, 3});
        System.out.println(IJsonUtil.toJson(s.shuffle()));
        System.out.println(IJsonUtil.toJson(s.reset()));


        Solution_2 s2 = new Solution_2(new int[]{1, 2, 3});
        System.out.println(IJsonUtil.toJson(s2.shuffle()));
        System.out.println(IJsonUtil.toJson(s2.reset()));
    }

    static class Solution_1 {

        private int[] original;

        private Random rand = new Random();

        public Solution_1(int[] nums) {
            original = nums;
        }

        public int[] reset() {
            return original;
        }

        public int[] shuffle() {
            int[] nums = new int[original.length];

            List<Integer> all = new ArrayList<>();
            for (int i = 0; i < original.length; i++) {
                all.add(original[i]);
            }

            for (int i = 0; i < nums.length; i++) {
                int k = rand.nextInt(all.size());
                nums[i] = all.get(k);
                all.remove(k);
            }

            return nums;
        }
    }

    /**
     * 思路
     * <p>
     * 我们可以用一个简单的技巧来降低之前算法的时间复杂度和空间复杂度，那就是让数组中的元素互相交换，这样就可以避免掉每次迭代中用于修改列表的时间了。
     * <p>
     * 算法
     * <p>
     * Fisher-Yates 洗牌算法跟暴力算法很像。在每次迭代中，生成一个范围在当前下标到数组末尾元素下标之间的随机整数。接下来，将当前元素和随机选出的下标所指的元素互相交换 - 这一步模拟了每次从 “帽子” 里面摸一个元素的过程，其中选取下标范围的依据在于每个被摸出的元素都不可能再被摸出来了。此外还有一个需要注意的细节，当前元素是可以和它本身互相交换的 - 否则生成最后的排列组合的概率就不对了。为了更清楚地理解这一过程，可以看下面这些动画：
     * <p>
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    static class Solution_2 {

        private int[] original;

        private Random rand = new Random();

        public Solution_2(int[] nums) {
            original = nums;
        }

        public int[] reset() {
            return original;
        }

        public int[] shuffle() {
            int[] nums = original.clone();

            for (int i = 0; i < nums.length; i++) {
                int k = rand.nextInt(nums.length - i);
                int tmp = nums[i + k];
                nums[i + k] = nums[i];
                nums[i] = tmp;
            }

            return nums;
        }
    }


}
