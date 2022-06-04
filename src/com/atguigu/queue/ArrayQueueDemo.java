package com.atguigu.queue;

import java.util.Scanner;

/**
 * @author shkstart
 * @create 2022-06-04 19:39
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
    //测试队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop){
            System.out.println("show:显示队列");//s
            System.out.println("exit:退出程序");
            System.out.println("add:添加数据到队列");//a
            System.out.println("get：从队列取出数据");//g
            System.out.println("head:查看队列头数据");//h
            key = scanner.next().charAt(0); //接收一个字符
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try{
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

//使用数组模拟队列 ArrayQueue类
class ArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部,指向队列头的前一个位置
        rear = -1;//指向队列尾，指向队列尾的数据（即是队列最后一个数据）
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加队列数据到队列
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满，不能加入数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //获取队列数据
    public int getQueue(){
        if(isEmpty()){
             throw new RuntimeException("队列空，不能获取数据");
        }
        front++;//front后移
        return arr[front];
    }

    //显示队列所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列空的，没有数据");
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列的头数据
    public int headQueue(){
        //
        if(isEmpty()){
            System.out.println("队列空的，没有数据");
            throw new RuntimeException("队列空，不能获取数据");
        }
        return arr[front+1];
    }
}
