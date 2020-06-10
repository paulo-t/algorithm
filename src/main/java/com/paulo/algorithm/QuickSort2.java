package com.paulo.algorithm;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.ArrayUtils;

/**
 * 双路快速排序
 * 解决了大量重复数据的问题
 */
public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr = {1,9,2,7,8,3,2,5,0,-1,100};
        sort(arr,11);
        System.out.println(JSON.toJSONString(arr));
    }

    public static void sort(int[] arr, int n) {
        __sort(arr,0,n-1);
    }

    private static void __sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = __partition2(arr, l, r);
        __sort(arr, l, p - 1);
        __sort(arr, p + 1, r);
    }

    private static int __partition2(int[] arr, int l, int r) {
        //[l+1,i) <= arr[l]   (j,r] >= arr[l]
        int i = l + 1, j = r;

        while (true) {
            while (i < r && arr[i] < arr[l]) i++;
            while (j > l + 1 && arr[j] > arr[l]) j--;
            if (j <= i) break;
            //在等于时依然交换，解决了数据的平衡问题
            ArrayUtils.swap(arr, i, j);
            i++;
            j--;
        }
        ArrayUtils.swap(arr, j, l);
        return j;
    }
}
