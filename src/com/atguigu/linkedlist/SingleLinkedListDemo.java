package com.atguigu.linkedlist;

import java.util.Stack;

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
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.list();

        System.out.println();

        HeroNode newHeroNode = new HeroNode(2,"卢俊义","小尾巴");
        singleLinkedList.update(newHeroNode);
        singleLinkedList.list();

        //
        System.out.println();
        singleLinkedList.del(1);
        singleLinkedList.list();

        System.out.println();
        System.out.println(getLength(singleLinkedList.getHead()));

        System.out.println();
        HeroNode res = findLastNode(singleLinkedList.getHead(),1);
        System.out.println("倒数的节点" + res);

        System.out.println();
        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();

        System.out.println();
        reversePrint(singleLinkedList.getHead());

        //测试合并单链表
        System.out.println();
        System.out.println("合并的单链表");
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        HeroNode hero5 = new HeroNode(1,"a","a");
        HeroNode hero6 = new HeroNode(2,"b","b");
        HeroNode hero7 = new HeroNode(4,"c","c");
        singleLinkedList1.add(hero5);
        singleLinkedList1.add(hero6);
        singleLinkedList1.add(hero7);
        SingleLinkedList res1 = concatList(singleLinkedList.getHead(),singleLinkedList1.getHead());
        res1.list();
    }

    //查找倒数第k个节点+
    //接收head节点，同时接收一个index
    //index 表示倒数第k个节点
    //遍历节点,得到链表总长度 getLength()
    //遍历 getLength() - index 可已得到倒数的节点
    public static HeroNode findLastNode(HeroNode head,int index){
        if(head.next == null){
            return null;
        }
        //获取节点总个数
        int size = getLength(head);
        //校验index
        if(index <=0 || index > size){
            return null;
        }
        //定义辅助变量
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //查找节点个数
    /**
     *
     * @param head 链表头节点
     * @return length 链表节点个数
     */
    public static int getLength(HeroNode head){
        if(head.next == null){
            return 0;
        }

        int length = 0;
        HeroNode cur = head.next;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }

    //反转链表
    public static void reverseList(HeroNode head){
        if(head.next == null || head.next.next == null){
            return;
        }

        HeroNode cur = head.next; //定义辅助变量，帮助遍历链表
        HeroNode next = null; //用于保存next
        HeroNode reverseHead = new HeroNode(0,"","");

        while (cur != null){
            next = cur.next;//暂时保存下一个节点
            cur.next = reverseHead.next;//将cur的下一个节点指向新 的链表最前端
            reverseHead.next = cur;//将cur链接到新的链表上
            cur = next;//让cur后移
        }
        //将head.next 指向reverseHead.next 实现链表的反转
        head.next = reverseHead.next;
    }

    //反向打印链表 将节点压入栈中
    public static void reversePrint(HeroNode head){
        if(head.next == null){
            return;
        }

        //创建栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;

        //将所有节点压入栈
        while (cur != null){
            stack.push(cur);
            cur = cur.next;//cur后移
        }

        //弹出栈
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    //课后练习
    //合并两个有序单链表，合并以后依然有序
    public static SingleLinkedList concatList(HeroNode list1Head,HeroNode list2Head){
        HeroNode newListHead = new HeroNode(0,"","");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode cur = newListHead.next;
        HeroNode cur1 = list1Head.next; //list1第一个节点,辅助变量保存当前节点
        HeroNode cur2 = list2Head.next; //list2 第一个节点,辅助变量保存当前节点

        if(cur1 == null && cur2 == null){
            return null;
        }

        while (cur1 != null && cur2 != null){
            if(cur1.no <= cur2.no){
                cur = cur1;
                singleLinkedList.add(cur);
                singleLinkedList.list();
                cur1 = cur1.next;
            } else {
                cur = cur2;
                singleLinkedList.add(cur);
                singleLinkedList.list();
                cur2 = cur2.next;
            }

        }
        return singleLinkedList;
    }
}

//定义SingleLinkedList 管理英雄
class SingleLinkedList{
    private HeroNode head = new HeroNode(0,"","");

    //返回头节点
    public HeroNode getHead() {
        return head;
    }

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

    //根据英雄排名添加
    //如果排名相同，则添加失败
    public void addByOrder(HeroNode heroNode){
        //头节点不能动，因此需要一个辅助变量 来帮助找到添加的位置
        //单链表，因此寻找的temp位于插入位置的前一个节点，否则无法插入
        HeroNode temp = head;
        boolean flag = false;//标识添加的编号是否存在
        while (true){
            if(temp.next == null){ //链表已经在最后了
                break;
            }
            if(temp.next.no > heroNode.no){//在temp后面插入位置
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next; //后移遍历链表
        }

        if(flag){
            System.out.printf("编号已存在\n",heroNode.no);
        }else {
            heroNode.next = temp.next;
            /*
            if(temp.next == null)
                temp:{
                    data,
                    next: null
                }

                heroNode:{
                    data
                    next:null
                }
            */
            temp.next = heroNode;
            /*
            头节点
                head:{
                    data
                    next: heroNode  //hero1
                }
                hero1:{
                    data,
                    next:null
                }
            */
        }

    }

    //删除节点
    //头节点不能动，使用辅助变量temp找到待删除节点的前一个节点
    //根据no删除
    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;

        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.printf("要删除的 %d 节点不存在，\n",no);
        }
    }

    //根据编号no修改节点信息,no不做修改
    public void update(HeroNode newHeroNode){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else{
            System.out.printf("没有找到编号 %d 的节点，不能修改 \n" , newHeroNode.no);
        }
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
                    //next +
                '}';
    }
}

