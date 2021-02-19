package com.servi.study.leetcode;

public class LeetCode_154 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_154().findMin(new int[]{2, 2, 2, 0, 1, 2}));
    }

    public int findMin2(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else {
                int x = i;
                for (int k = i + 1; k < j; k++) {
                    if (numbers[k] < numbers[x]) x = k;
                }
                return numbers[x];
            }
        }
        return numbers[i];
    }

    public int findMin(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;

        while (numbers[left] >= numbers[right]) {
            if (right - left == 1) {
                return numbers[right];
            }
            int mid = (right - left) / 2 + left;
            if (numbers[left] == numbers[right] && numbers[left] == numbers[mid]) {
                return getMin(numbers, left, right);
            }
            if (numbers[left] <= numbers[mid]) {
                left = mid;
            } else if (numbers[right] >= numbers[mid]) {
                right = mid;
            }
        }
        return numbers[left];
    }

    private int getMin(int[] numbers, int left, int right) {
        int min = numbers[left];
        for (int i = left + 1; i <= right; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }
        return min;
    }
}
