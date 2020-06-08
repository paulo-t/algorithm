package com.paulo.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.Random;

public class QuickSort {
    public static void sort(int[] arr, int n) {
        __sort(arr, 0, n - 1);
    }


    private static void __sort(int[] arr, int l, int r) {
        if (r -l <= 15) {
            InsertSort.sort(arr,l,r);
            return;
        }

        //随机选择一个数作为中间值，防止数组有序时调用树的深度过深
        Random random = new Random();
        int num = random.nextInt(r - l + 1) + l;
        int temp = arr[l];
        arr[l] = arr[num];
        arr[num] = temp;


        int index = __partition(arr, l, r);

        __sort(arr, l, index - 1);
        __sort(arr, index + 1, r);
    }

    private static int __partition(int[] arr, int l, int r) {
        int j = l;

        for (int i = l + 1; i <= r; i++) {
            if(arr[i] < arr[l]){
                int temp = arr[j+1];
                arr[j+1] = arr[i];
                arr[i] = temp;
                j++;
            }
        }

        int temp = arr[l];
        arr[l] = arr[j];
        arr[j] = temp;
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,2,9,7,3,8,4,20,0};
        QuickSort.sort(arr,10);
        System.out.println(JSON.toJSONString(arr));
    }
}
