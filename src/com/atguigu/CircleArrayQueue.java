package com.atguigu;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Scanner;

/**
 * @author shkstart
 * @create 2022-06-04 20:46
 */
public class CircleArrayQueue {
    public static void main(String[] args) {
//测试环行队列
        CircleArray queue = new CircleArray(4);
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

class CircleArray{
    private int maxSize;
    private int front; //调整初始值为0
    private int rear;//调整初始值为0
    private int[] arr;

    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //判断队列是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
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

        //直接将数据加入
        arr[rear] = n;
        //将rear后移,这里考虑取模
        rear = (rear + 1) % maxSize;


    }

    //获取队列数据,出队列
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空，不能获取数据");
        }
        //先把front 对应的值保留到一个临时变量
        //将front后移,考虑取模
        //将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列空的，没有数据");
        }

        //从front开始遍历,遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
        }
    }

    //求出当前队列有效数据
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头数据
    public int headQueue(){
        //
        if(isEmpty()){
            System.out.println("队列空的，没有数据");
            throw new RuntimeException("队列空，不能获取数据");
        }
        return arr[front];
    }
}
