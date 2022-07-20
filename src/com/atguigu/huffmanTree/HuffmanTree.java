package com.atguigu.huffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node root = createHuffmanTree(arr);

        preOrder(root);
    }

    public static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        } else {
            System.out.println("空树，无法遍历");
        }
    }

    //创建赫夫曼树的方法
    public static Node createHuffmanTree(int[] arr){
        List<Node> nodes = new ArrayList<Node>();
        for (int value :
                arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1){
            //排序从大到小
            Collections.sort(nodes);

            //取出最小节点
            Node leftNode = nodes.get(0);
            //取出第二小的节点
            Node rightNode = nodes.get(1);

            //构建新二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //从ArrayList删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            //将parent加入到nodes
            nodes.add(parent);
        }

        //返回赫夫曼树root节点
        return nodes.get(0);
    }
}

//节点类
class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "[" +
                "value=" + value +
                ']';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}

