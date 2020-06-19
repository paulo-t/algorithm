package com.paulo.algorithm;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Random;

/**
 * 公平的洗牌算法
 * 公平: n个元素一共有n!种排序结果，每种出现的概率都相同=每个元素在每个位置出现的概率都相同
 *
 * @author: create by paulo
 * @version: v1.0
 * @description: com.paulo.algorithm
 * @date:2020/6/19
 */
public class KnuthShuffle {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 10, 6, 8, 9, 2, 3, 6, 5};
        shuffle(arr,9);
        System.out.println(JSON.toJSONString(arr));
    }

    private static void shuffle(int[] arr, int n) {
        Random random = new Random(System.currentTimeMillis());

        for (int i = n - 1; i >= 0; i--) {
            ArrayUtils.swap(arr,i,random.nextInt(i + 1));
        }
    }
}
