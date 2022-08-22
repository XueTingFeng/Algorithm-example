package com.book.BagQueueStack;

//链表构建栈
public class LinkedStack {
    public static void main(String[] args) {

    }
}

class MyStack{
    private Node first;//栈顶
    private int n;//元素数量

    //定义节点
    private class Node {
        String data;
        Node next;
    }

    //栈是否为空
    public boolean isEmpty(){
        return first == null;
    }

    //返回栈元素个数
    public int size(){
        return n;
    }

    //向栈顶添加元素
    public void push(String data){
        Node oldFirst = first;
        first = new Node();
        first.data = data;
        first.next = oldFirst;
        n++;
    }

    //从栈顶删除元素
    public String pop(){
        String data = first.data;
        first = first.next;
        n--;
        return data;
    }

}




