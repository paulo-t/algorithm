package com.paulo.algorithm;

/**
 * 归并排序算法
 * 时间复杂度:O(NLogN)
 */
public class MergerSort {

    /**
     * 自顶向下的归并排序
     */
    public static void sort(int[] arr, int n) {
        __sort(arr, 0, n - 1);
    }

    /**
     * 字底向上的归并排序，效率相比于自顶向下略低，但是不用数组索引操作元素，可以用来做链表排序
     */
    public static void sortBU(int[] arr, int n) {
        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0;/**i+sz>=n表明只有左半部分*/ i + sz < n; i += sz + sz) {
                __merge(arr, i, i + sz - 1, /**右半部分的元素不足sz个时取所有的*/Math.min(i + sz + sz - 1,n-1));
            }
        }
    }

    private static void __sort(int[] arr, int l, int r) {
        if (l >= r) {
            //优化2:在数组中元素个数很小的情况下，数组有序的可能性越大,在数组接近有序的情况下插入排序的时间复杂度接近O(N)
            //在元素个数足够小的情况下O(NLogN)和O(NN^2)前面的N对排序的影响会更大，插入排序前面的系数较小
            InsertSort.sort(arr, l, r);
            return;
        }

        int mid = (l + r) / 2;
        __sort(arr, l, mid);
        __sort(arr, mid + 1, r);
        //优化1:如果左边的部分的最后一个元素<=右边部分的第一个元素就不用再进行合并
        if (arr[mid] <= arr[mid + 1]) {
            return;
        }
        __merge(arr, l, mid, r);
    }

    private static void __merge(int[] arr, int l, int mid, int r) {
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
            } else if (aux[i - l] > aux[j - l]) {
                arr[k] = aux[j - l];
                j++;
            } else {
                arr[k] = aux[i - l];
                i++;
            }
        }
    }
}
