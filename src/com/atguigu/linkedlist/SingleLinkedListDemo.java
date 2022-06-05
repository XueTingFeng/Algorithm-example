package com.atguigu.linkedlist;

/**
 * @author shkstart
 * @create 2022-06-05 20:35
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero4);

        singleLinkedList.list();
    }
}

//定义SingleLinkedList 管理英雄
class SingleLinkedList{
    private HeroNode head = new HeroNode(0,"","");

    //添加节点到单向链表
    //找到最后一个节点
    //将最后节点的next域指向新的节点
    public void add(HeroNode heroNode){
        HeroNode temp = head;

        while (true){
            //找到链表的最后
            if(temp.next == null){
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //退出循环时，temp就指向了链表的最后
        //将最后的节点next指向新的节点
        temp.next = heroNode;
    }

    //显示链表【遍历】
    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //头节点不能动，因此需要辅助变量来遍历
        HeroNode temp = head.next;
        while (true){
            if(temp == null){
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }
}

//定义HeroNode,每个HeroNode 对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no,String name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +

                '}';
    }
}

