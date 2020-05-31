package com.paulo.algorithm.linkedlist;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}
