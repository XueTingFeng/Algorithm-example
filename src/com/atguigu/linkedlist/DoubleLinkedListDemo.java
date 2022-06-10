package com.atguigu.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表测试");
        HeroNode2 hero1 = new HeroNode2(1,"宋江","及时雨");
        HeroNode2 hero2 = new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 hero3 = new HeroNode2(4,"林冲","豹子头");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.list();

        System.out.println();

        HeroNode2 newHero = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHero);
        doubleLinkedList.list();

        System.out.println();

        doubleLinkedList.del(4);
        doubleLinkedList.list();

        System.out.println();
        HeroNode2 newHero2 = new HeroNode2(5, "公孙胜", "入云龙");
        doubleLinkedList.addByOrder(newHero2);
        doubleLinkedList.list();

        System.out.println();
        HeroNode2 newHero3 = new HeroNode2(3, "薛霆峰", "xtf");
        doubleLinkedList.addByOrder(newHero3);
        doubleLinkedList.list();

    }
}

class DoubleLinkedList{

    //初始化头节点
    private HeroNode2 head = new HeroNode2(0,"","");

    //返回头节点
    public HeroNode2 getHead(){
        return head;
    }

    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //头节点不能动，因此需要辅助变量来遍历
        HeroNode2 temp = head.next;
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

    public void add(HeroNode2 heroNode){
        HeroNode2 temp = head;

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
        heroNode.pre = temp;
    }

    public void addByOrder(HeroNode2 heroNode){
        HeroNode2 temp = head;
        boolean flag = false;
        while (true){
            if(temp.next == null){
                temp.next = heroNode;
                heroNode.pre = temp;
                return;
            }
            if(temp.next.no > heroNode.no){ //找到插入 heroNode的前一个节点  temp heroNode
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.printf("编号已存在\n",heroNode.no);
        }else {
            heroNode.pre = temp;
            heroNode.next = temp.next;
            temp.next = heroNode;

//            System.out.println("打印");
//            System.out.println(temp);
//            System.out.println("打印");
//            System.out.println(heroNode);
        }
    }

    public void update(HeroNode2 newHeroNode){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if(temp == null){
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

    public void del(int no){

        if(head.next == null){
            System.out.println("链表为空，无法删除");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;

        while (true){
            if(temp == null){
                break;
            }
            if(temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            //temp.next = temp.next.next;
            temp.pre.next = temp.next;

            //如果是最后一个节点，不需要执行下面这句话,空指针异常
            if(temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.printf("要删除的 %d 节点不存在，\n",no);
        }
    }


}

class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no,String name,String nickname){
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
                //  ", next='" + next +
                '}';
    }
}
