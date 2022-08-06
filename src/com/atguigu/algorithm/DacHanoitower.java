package com.atguigu.algorithm;

/**
 * @author shkstart
 * @create 2022-08-06 20:12
 */
public class DacHanoitower {
    public static void main(String[] args) {
        hanoiTower(3,'A','B','C');
    }

    //汉诺塔移动方法 分治算法
    public static void hanoiTower(int num,char a,char b,char c){
        //如果只有一个盘
        if(num == 1){
            System.out.println("第1个盘从" + a + "->" + c);
        } else {
            //n>=2 看做两个盘 1.最下边的一个盘 2.上面所有盘
            //1.先把 最上面的所有盘 A -> B,移动过程使用到c
            hanoiTower(num-1,a,c,b);
            //2.把最下边的盘A->C
            System.out.println("第" + num + "个盘" + a + "->" + c);
            //3. 把B塔所有盘移动到c
            hanoiTower(num-1,b,a,c);
        }
    }
}
