package com.paulo.algorithm;

/**
 * 插入排序算法
 * 时间复杂度:O(N^2)
 * 排序元素有序时时间复杂度退化成O(N),常用来做复杂排序算法中间部分排序的优化
 */
public class InsertSort {
    public static void sort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void sort(int[] arr, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            int temp = arr[i];
            int j = i;
            while (j > l && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
