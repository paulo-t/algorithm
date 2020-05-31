package com.paulo.algorithm.linkedlist;

import com.alibaba.fastjson.JSON;

import java.util.Objects;

/**
 * 单向链表
 */
public class SingleLinkedList<T> {
    //头结点
    private Node<T> head = new Node<T>(null);

    /**
     * 获取头结点
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * 在链表最后添加节点
     */
    public void add(Node<T> node) {
        Node<T> aux = head;
        while (!Objects.isNull(aux.getNext())) {
            aux = aux.getNext();
        }

        aux.setNext(node);
    }

    /**
     * 删除节点
     */
    public void delete(T data) {
        Node<T> aux = head;

        boolean isFind = false;

        while (true) {
            if (Objects.isNull(head.getNext())) {
                break;
            }
            if (aux.getNext().getData().equals(data)) {
                isFind = true;
                break;
            }
            aux = aux.getNext();
        }

        if (isFind) {
            aux.setNext(aux.getNext().getNext());
        } else {
            System.out.println("删除的节点不存在");
        }
    }


    /**
     * 遍历链表
     */
    public void list() {
        Node<T> aux = head;
        if (Objects.isNull(aux.getNext())) {
            System.out.println("linked list is null.");
        }

        while (!Objects.isNull(aux.getNext())) {
            aux = aux.getNext();
            System.out.println(JSON.toJSONString(aux));
        }
    }

    /**
     * 逆序链表
     */
    public void reverse() {
        //指向前一个元素的指针
        Node<T> pre = null;
        //指向当前元素的指针
        Node<T> current = head.getNext();

        if (Objects.isNull(current.getNext())) {
            return;
        }

        while (!Objects.isNull(current)) {
            //指向下一个元素的指针
            Node<T> next = current.getNext();
            current.setNext(pre);
            pre = current;
            current = next;
        }

        head.setNext(pre);
    }

    /**
     * 查找链表中间元素的值
     */

    public T findMid(){
        Node<T> aux = head;


        if(Objects.isNull(aux.getNext())){
            System.out.println("链表为空");
        }

        if(Objects.isNull(aux.getNext().getNext())){
            return aux.getNext().getData();
        }

        Node<T> next = aux.getNext();
        Node<T> twoNext = aux.getNext();

        while(!Objects.isNull(twoNext.getNext()) && !Objects.isNull(twoNext.getNext().getNext())){
            next = next.getNext();
            twoNext = twoNext.getNext().getNext();
        }

        return next.getData();
    }

    /**
     * 判断是否是循环链表
     */

    public boolean isColumn(){
        Node<T> aux = head;


        if(Objects.isNull(aux.getNext())){
            System.out.println("链表为空");
        }

        if(Objects.isNull(aux.getNext().getNext())){
            return false;
        }

        Node<T> next = aux.getNext();
        Node<T> twoNext = aux.getNext();

        while(!Objects.isNull(twoNext.getNext()) && !Objects.isNull(twoNext.getNext().getNext())){
            next = next.getNext();
            twoNext = twoNext.getNext().getNext();

            if(twoNext.getData().equals(next.getData())){
                return true;
            }
        }

        return false;
    }
}
