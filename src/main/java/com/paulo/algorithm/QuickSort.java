package com.paulo.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.Random;

import static org.apache.commons.lang3.ArrayUtils.swap;

/**
 * 单路快速排序，大部分情况下排序速度都很快
 * 缺点: 如果存在大量重复的元素(比如100w条数据中全都是1-10的数字)会导致每次递归一半数据很大一半数据很小
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,9,2,7,3,0,5,6,7};
        sort(arr,9);
        System.out.println(JSON.toJSONString(arr));
    }
    public static void sort(int[] arr, int n) {
        __sort(arr,0,n-1);
    }

    public static void __sort(int[] arr, int l, int r) {
        if (r - l < 15) {
            InsertSort.sort(arr,l,r);
            return;
        }

        int p = __partition(arr, l, r);
        __sort(arr, l, p - 1);
        __sort(arr, p + 1, r);
    }

    public static int __partition(int[] arr, int l, int r) {
        //解决有序数组时
        Random random = new Random(System.currentTimeMillis());
        int swapIndex = random.nextInt(r - l + 1) + l;
        swap(arr,l,swapIndex);

        int j = l;
        //[l+1,j] <= arr[l], [j+1,i) > arr[l]
        for (int i = l + 1; i <= r; i++) {
            if(arr[i] < arr[l]){
                swap(arr,j+1,i);
                j++;
            }
        }

        swap(arr,l,j);

        return j;
    }
}
