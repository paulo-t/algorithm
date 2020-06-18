package com.paulo.algorithm;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Random;

/**
 * 三路快速排序
 * 等于的部分不进行排序
 */
public class QuickSort3 {
    public static void main(String[] args) {
        int[] arr = {1,7,2,0,9,3,8,7,6};
        sort(arr,9);
        System.out.println(JSON.toJSONString(arr));
    }

    public static void sort(int[] arr, int n) {
        __sort(arr,0,n-1);
    }

    private static void __sort(int[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertSort.sort(arr, l, r);
            return;
        }

        Random random = new Random(System.currentTimeMillis());
        int randomNum = random.nextInt(r - l + 1) + l;
        ArrayUtils.swap(arr, randomNum, l);

        //[l+1,lt] < arr[l]; (lt,i) = arr[l]; [gt,r] > arr[l]
        int lt = l, gt = r + 1;

        for (int i = l + 1; i < gt; i++) {
            if (arr[i] < arr[l]) {
                ArrayUtils.swap(arr, lt + 1, i);
                lt++;
                i++;
            } else if (arr[i] > arr[l]) {
                ArrayUtils.swap(arr, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }

        ArrayUtils.swap(arr, l, lt);
        __sort(arr, l, lt - 1);
        __sort(arr, gt, r);
    }
}
