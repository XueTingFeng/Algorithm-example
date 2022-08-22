package com.book.BagQueueStack;
import java.util.Iterator;


public class LinkedBag {
}

class MyBag implements Iterable<String>{
    private Node first;//栈顶
    private int n;//元素数量

    //定义节点
    private class Node {
        String data;
        Node next;
    }

    //向背包添加元素
    public void add(String data){
        Node oldFirst = first;
        first = new Node();
        first.data = data;
        first.next = oldFirst;
        n++;
    }

    //背包是否为空
    public boolean isEmpty(){
        return first == null;
    }

    //返回元素个数
    public int size(){
        return n;
    }

    public Iterator<String> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<String>{
        private Node current = first;

        @Override
        public boolean hasNext(){
            return current != null;
        }

        @Override
        public String next() {
            String data = current.data;
            current = current.next;
            return data;
        }

        @Override
        public void remove() {}
    }


}
