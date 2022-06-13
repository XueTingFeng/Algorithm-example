package com.atguigu.linkedlist;

public class Josepfu {

    public static void main(String[] args) {
    //测试
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        //24153
        circleSingleLinkedList.countBoy(1,2,5);
    }
}

//创建一个环形的单向链表
class CircleSingleLinkedList{
    //创建first节点,当前没有编号
    private Boy first = null;

    //添加节点，构建环形的链表
    public void addBoy(int nums){
        //nums 做一个数据校验
        if(nums < 1){
            System.out.println("nums的值不正确");
            return;
        }

        Boy curBoy = null;//辅助指针，帮助构建环形链表
        //使用for来创建环形链表

        for (int i = 1; i <= nums; i++) {
            //根据编号创建节点
            Boy boy = new Boy(i);

            //如果是第一个节点
            if(i == 1){
                first = boy;
                first.setNext(first);//构成环
                curBoy = first;//让cur指向第一个节点
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void showBoy(){
        if(first == null){
            System.out.println("没有任何节点");
            return;
        }
        //first不能动,使用辅助指针完成遍历
        Boy curBoy = first;
        while (true){
            System.out.printf("编号%d \n",curBoy.getNo());
            if(curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();//后移
        }
    }

    //根据用户输入，计算出圈的顺序
    /**
     *
     * @param startNo 表示从第几个节点开始
     * @param countNum 表示数多少下
     * @param nums 表示最初有多少个节点
     */
    public void countBoy(int startNo,int countNum,int nums){
        //先对数据校验
        if(first == null || startNo < 1 || startNo > nums){
            System.out.println("参数输入有误，请重新输入");
            return;
        }

        //创建辅助指针，帮助节点完成出圈
        Boy helper = first;

        while (true){
            if(helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }

        //boy报数前 先让first 和 helper 移动 k-1 次
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //boy报数时,让first 和 helper 指针同时移动 m - 1次, 然后出圈
        //循环，直到圈中只有一个节点
        while (true){
            if(helper == first){
                break;
            }
            //让first 和 helper 指针同时移动countNum - 1
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            //first指向的节点，就是要出圈的节点
            System.out.printf("%d出圈\n",first.getNo());
            //将first指向的节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中boy的编号%d \n",first.getNo());
    }
}

//创建boy类，表示一个节点
class Boy {
    private int no;
    private Boy next;

    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
