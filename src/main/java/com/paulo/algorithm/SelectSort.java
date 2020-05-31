package com.paulo.algorithm;

/**
 * 选择排序
 * 时间复杂度: O(N^2)
 */
public class SelectSort {
    public static void sort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            int minVal = arr[i];

            for (int j = i + 1; j < n; j++) {
                if(arr[j] < minVal){
                    minIndex = j;
                    minVal = arr[j];
                }
            }

            if(minIndex != i){
                int temp = arr[i];
                arr[i] = minVal;
                arr[minIndex] = temp;
            }
        }
    }
}
