package com.paulo.algorithm.heap;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.ArrayUtils;

/**
 * 最大堆
 */
public class MaxHeap {
    private Integer[] data;

    private int counter;

    private int capacity;

    public MaxHeap(int capacity) {
        data = new Integer[capacity + 1];
        counter = 0;
        this.capacity = capacity;
    }

    public Integer[] getData() {
        return data;
    }

    public boolean isEmpty(){
        return counter == 0;
    }

    /**
     * 获取最大值
     */
    public Integer pop() {
        if (counter <= 0) {
            return null;
        }
        int ret = data[1];
        data[1] = null;

        shiftDown();
        counter--;
        return ret;
    }

    public void shiftDown() {
        int j = 1;
        while (j * 2 <= counter) {
            if (j * 2 + 1 <= counter && data[j * 2 + 1] > data[j * 2]) {
                ArrayUtils.swap(data,j,j*2+1);
                j = j*2 +1;
            } else {
                ArrayUtils.swap(data,j,j*2);
                j *= 2;
            }

        }
    }

    /**
     * 添加数据
     */
    public void push(int item) {
        if (counter + 1 > capacity) {
            System.out.println("heap is full");
            return;
        }

        data[counter + 1] = item;
        counter++;
        shiftUp(counter);
    }

    private void shiftUp(int i) {
        int aux = data[i];
        int j = i;

        while (j > 1 && data[j / 2] < aux) {
            data[j] = data[j / 2];
            j /= 2;
        }

        data[j] = aux;
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        heap.push(1);
        heap.push(10);
        heap.push(2);
        heap.push(12);

        while(! heap.isEmpty()){
            System.out.println(heap.pop());
        }

        System.out.println(JSON.toJSONString(heap.getData()));
    }

}
