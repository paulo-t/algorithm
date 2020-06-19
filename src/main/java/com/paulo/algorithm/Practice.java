package com.paulo.algorithm;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Random;

/**
 * @author: create by paulo
 * @version: v1.0
 * @description: com.paulo.algorithm
 * @date:2020/6/18
 */
public class Practice {
    public static void main(String[] args) {
        int[] arr = {1, 9, 5, 6, 78, 3, 2, 6, 7, 0, 34};
        sort(arr, 11);
        System.out.println(JSON.toJSONString(arr));
    }

    private static void sort(int[] arr, int n) {
        //selectSort(arr, n);
        //insertSort(arr, n);
        //insertSort(arr,0,n-1);
        //mergerSort(arr, 0, n - 1);
        //mergerSortBU(arr,n);
        //quickSort(arr, 0, n - 1);
        //quickSort2(arr, 0, n - 1);
        quickSort3(arr,0,n-1);
    }

    private static void quickSort3(int[] arr, int l, int r) {
        if (r - l <= 15) {
            insertSort(arr, l, r);
            return;
        }
        Random random = new Random(System.currentTimeMillis());
        int num = random.nextInt(r - l + 1);
        ArrayUtils.swap(arr, num, l);

        // [l+1,lt] < val; [lt + 1,i) = val; [gt,r] > val
        int lt = l, gt = r + 1;
        for (int i = l; i <= r; i++) {
            if(arr[i] == arr[l]){
                i++;
            }else if(arr[i] < arr[l]){
                ArrayUtils.swap(arr,i,lt+1);
                lt++;
                i++;
            }else {
                ArrayUtils.swap(arr,i,gt-1);
                gt--;
            }
        }

        ArrayUtils.swap(arr,lt,l);
        quickSort3(arr,l,lt -1);
        quickSort3(arr,gt,r);
    }


    private static void quickSort2(int[] arr, int l, int r) {
        if (r - l <= 15) {
            insertSort(arr, l, r);
            return;
        }
        int partition = partition2(arr, l, r);
        quickSort(arr, l, partition);
        quickSort(arr, partition + 1, r);
    }

    private static int partition2(int[] arr, int l, int r) {
        Random random = new Random(System.currentTimeMillis());
        int num = random.nextInt(r - l + 1);
        ArrayUtils.swap(arr, num, l);

        int i = l + 1, j = r;
        while (true) {
            while (arr[i] < arr[l]) i++;
            while (arr[j] > arr[l]) j--;
            if (i >= j) {
                break;
            }
            ArrayUtils.swap(arr, i, j);
        }

        ArrayUtils.swap(arr, l, j);
        return j;
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (r - l <= 15) {
            insertSort(arr, l, r);
            return;
        }
        int partition = partition(arr, l, r);
        quickSort(arr, l, partition);
        quickSort(arr, partition + 1, r);
    }

    private static int partition(int[] arr, int l, int r) {
        Random random = new Random(System.currentTimeMillis());
        int num = random.nextInt(r - l + 1);
        ArrayUtils.swap(arr, num, l);

        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < arr[l]) {
                ArrayUtils.swap(arr, j + 1, i);
                j++;
                i++;
            }
        }

        ArrayUtils.swap(arr, l, j);

        return j;
    }

    private static void mergerSortBU(int[] arr, int n) {
        for (int sz = 1; sz <= n; sz *= 2) {
            for (int i = 0; i + sz < n; i = i + sz + sz) {
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
        }
    }


    private static void mergerSort(int[] arr, int l, int r) {
        if (r - l <= 15) {
            insertSort(arr, l, r);
            return;
        }

        int mid = (l + r) / 2;
        mergerSort(arr, l, mid);
        mergerSort(arr, mid + 1, r);
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] aux = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    private static void insertSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int j = i;
            int auxVal = arr[i];

            while (j > 0 && auxVal < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = auxVal;
        }
    }

    private static void insertSort(int[] arr, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            int j = i;
            int auxVal = arr[i];

            while (j > l && auxVal < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = auxVal;
        }
    }


    private static void selectSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            int minValue = arr[i];

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < minValue) {
                    minIndex = j;
                    minValue = arr[j];
                }
            }

            if (minIndex != i) {
                ArrayUtils.swap(arr, minIndex, i);
            }
        }
    }
}
