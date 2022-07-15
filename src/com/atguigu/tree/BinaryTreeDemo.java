package com.atguigu.tree;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        //创建二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        HeroNode root = new HeroNode(1, "小明");
        HeroNode node2 = new HeroNode(2, "小红");
        HeroNode node3 = new HeroNode(3, "小李");
        HeroNode node4 = new HeroNode(4, "小方");
        HeroNode node5 = new HeroNode(5, "小赵");

        //手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

        //测试
        System.out.println("前序遍历");
        binaryTree.preOrder();

        //测试
        System.out.println("中序遍历");
        binaryTree.infixOrder();

        //测试
        System.out.println("后序遍历");
        binaryTree.postOrder();

        //前序查找
        System.out.println("前序查找");
        HeroNode resNode = binaryTree.preOrderSearch(5);
        if(resNode != null){
            System.out.printf("no=%d name=%s",resNode.getNo(),resNode.getName());
        } else {
            System.out.println("没有找到");
        }

        //中序查找
        System.out.println("中序查找");
        HeroNode resNode2 = binaryTree.infixOrderSearch(5);
        if(resNode2 != null){
            System.out.printf("no=%d name=%s",resNode2.getNo(),resNode2.getName());
        } else {
            System.out.println("没有找到");
        }

        //后序查找
        System.out.println("后序查找");
        HeroNode resNode3 = binaryTree.postOrderSearch(5);
        if(resNode3 != null){
            System.out.printf("no=%d name=%s",resNode3.getNo(),resNode3.getName());
        } else {
            System.out.println("没有找到");
        }

        //删除节点
        System.out.println();
        binaryTree.delNode(3);
        System.out.println("删除后");
        binaryTree.preOrder();
    }

}

//定义二叉树
class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root){
        this.root = root;
    }

    //前序遍历
    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder(){
        if(this.root != null){
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void postOrder(){
        if(this.root != null){
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序查找
    public HeroNode preOrderSearch(int no){
        if(root != null){
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //中序查找
    public HeroNode infixOrderSearch(int no){
        if(root != null){
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    //后序查找
    public HeroNode postOrderSearch(int no){
        if(root != null){
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    //删除节点
    public void delNode(int no){
        if(root != null){
            //判断root是否就是要删除的节点
            if(root.getNo() == no){
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("空树无法删除");
        }
    }
}

//节点
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void delNode(int no){
        //左节点不为空，并且左子节点就是要删除的节点
        if(this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        //右节点不为空，并且右子节点就是要删除的节点
        if(this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        //向左子树递归
        if(this.left != null){
            this.left.delNode(no);
        }
        //向右子树递归
        if(this.right != null){
            this.right.delNode(no);
        }

        //todo
        //删除节点如果有子节点，将子节点上移
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);//先输出父节点
        //递归向左子树前序遍历
        if(this.left != null){
            this.left.preOrder();
        }
        //右子树
        if(this.right != null){
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder(){
        //左子树中序遍历
        if(this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        //右子树
        if(this.right != null){
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder(){
        if(this.left != null){
            this.left.postOrder();
        }
        if(this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序遍历查找

    /**
     *
     * @param no 通过no查找
     * @return 找到返回node，否则返回null
     */
    public HeroNode preOrderSearch(int no){
        //比较当前节点是不是
        System.out.println("进入前序查找");
        if(this.no == no){
            return this;
        }
        //判断左子节点是否为空，如果不为空，则递归前序查找
        //如果左递归查找到节点，则返回
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode != null){//左子树上找到了
            return resNode;
        }

        //没有找到，往右子树查找
        //判断右子节点是否为空，如果不为空，往右递归前序查找
        if(this.right != null){
            resNode = this.right.preOrderSearch(no);
        }

        return resNode;
    }

    //中序查找
    public HeroNode infixOrderSearch(int no){
        HeroNode resNode = null;
        //判断左子节点是否为空，如果不为空，递归中序查找
        if(this.left != null){
            resNode = this.left.infixOrderSearch(no);
        }
        //如果找到，则返回
        if(resNode != null){
            return resNode;
        }
        //如果没有找到,就和当前节点比较，是则返回
        System.out.println("进入中序查找");
        if(this.no == no){
            return this;
        }
        //否则继续进行右递归的中序查找
        if(this.right != null){
            resNode = this.right.infixOrderSearch(no);
        }

        return resNode;
    }

    //后序查找
    public HeroNode postOrderSearch(int no){
        HeroNode resNode = null;
        //判断左节点是否为空,不为空，则递归后序查找
        if(this.left != null){
            resNode = this.left.postOrderSearch(no);
        }
        //如果左子树找到
        if(resNode != null){
            return resNode;
        }
        //左边没找到，往右子树递归后序查找
        if(this.right != null){
            resNode = this.right.postOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }

        System.out.println("进入后序查找");
        if(this.no == no){
            return this;
        }

        return resNode;
    }

}
