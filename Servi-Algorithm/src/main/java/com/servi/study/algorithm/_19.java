package com.servi.study.algorithm;

import com.servi.study.json.IJsonUtil;

/**
 * 排序算法
 */
public class _19 {

    public static void main(String[] args) {
        int[] a = new int[]{4, 5, 6, 1, 3, 2};

        //冒泡排序
       // bubbleSort(a, a.length);
        //插入排序
        insertionSort(a, a.length);
    }

    // 冒泡排序，a表示数组，n表示数组大小
    public static int[] bubbleSort(int[] a, int n) {
        if (n <= 1) return a;

        boolean already = true;
        for (int i = 0; i < n; i++) {
            already = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    already = false;
                }
            }
            if (already) {
                break;
            }
            System.out.println("冒泡排序:" + IJsonUtil.toJson(a));
        }

        return a;
    }

    // 插入排序，a表示数组，n表示数组大小
    public static int[] insertionSort(int[] a, int n) {
        if (n <= 1) return a;

        for (int i = 0; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
            System.out.println("插入排序:" + IJsonUtil.toJson(a));
        }

        return a;
    }
}
