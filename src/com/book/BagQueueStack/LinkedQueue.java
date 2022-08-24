package com.book.BagQueueStack;

//链表实现队列
public class LinkedQueue {
    public static void main(String[] args) {

    }
}

class MyQueue{
    private Node first;//指向最早添加的节点
    private Node last;//指向最后添加的节点
    private int n;

    //定义节点
    private class Node {
        String data;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return n;
    }

    //尾部添加元素
    public void enqueue(String data){
        Node oldLast = last;
        last = new Node();
        last.data = data;
        last.next = null;

        if(isEmpty()){
            first = last;
        } else {
            oldLast.next = last;
        }

        n++;
    }

    //头部删除元素
    public String dequeue(){
        String data = first.data;
        first = first.next;

        if(isEmpty()){
            last = null;
        }

        n--;
        return data;
    }
}
