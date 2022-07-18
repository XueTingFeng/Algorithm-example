package com.atguigu.tree;

public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();//1,2,4,5,3,6,7

        System.out.println();
        arrBinaryTree.infixOrder();//4,2,5,1,6,3,7

        System.out.println();
        arrBinaryTree.postOrder();//4,5,2,6,7,3,1
    }
}

class ArrBinaryTree{
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(){
        this.preOrder(0);
    }

    //顺序二叉树前序遍历
    public void preOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空");
        }
        System.out.println(arr[index]);
        //向左递归遍历
        if((index * 2 + 1) <arr.length){
            preOrder(index * 2 + 1);
        }
        //向右
        if((index * 2 + 2) <arr.length){
            preOrder(index * 2 + 2);
        }

    }

    //中序和后序遍历
    public void infixOrder(){
        this.infixOrder(0);
    }

    public void infixOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空");
        }
        //向左递归遍历
        if((index * 2 + 1) <arr.length){
            infixOrder(index * 2 + 1);
        }
        System.out.println(arr[index]);
        //向右
        if((index * 2 + 2) <arr.length){
            infixOrder(index * 2 + 2);
        }
    }

    public void postOrder(){
        this.postOrder(0);
    }

    public void postOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空");
        }
        //向左递归遍历
        if((index * 2 + 1) <arr.length){
            postOrder(index * 2 + 1);
        }
        //向右
        if((index * 2 + 2) <arr.length){
            postOrder(index * 2 + 2);
        }
        System.out.println(arr[index]);
    }
}
