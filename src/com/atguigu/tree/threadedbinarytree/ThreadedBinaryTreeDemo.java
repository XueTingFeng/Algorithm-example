package com.atguigu.tree.threadedbinarytree;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        //测试,以10节点测试
        HeroNode leftNode = node5.getLeft();
        System.out.println(leftNode);
        HeroNode rightNode = node5.getRight();
        System.out.println(rightNode);

        //遍历线索化二叉树
        System.out.println("线索化二叉树");
        threadedBinaryTree.threadedList();
    }
}

//实现线索化功能的二叉树
class ThreadedBinaryTree{
    private HeroNode root;

    //为了实现线索化，需要创建指向当前节点前驱节点的指针
    private HeroNode pre = null;

    public void setRoot(HeroNode root){
        this.root = root;
    }

    //重载threadedNodes
    public void threadedNodes(){
        this.threadedNodes(root);
    }

    //遍历线索化二叉树的方法
    public void threadedList(){
        //定义变量，存储当前遍历的节点
        HeroNode node = root;
        while (node != null){
            //循环找到leftType=1的节点, 当前例子为8号的节点
            //后面随着遍历而变化,因为leftType==1时,说明节点是线索化的
            //处理后的有效节点
            while(node.getLeftType() == 0){
                node = node.getLeft();
            }
            //输出当前节点
            System.out.println(node);
            //如果当前节点的右指针指向的后继节点，就一直输出
            while (node.getRightType() == 1){
                //获取当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }
            //替换遍历的节点
            node = node.getRight();
        }
    }

    //中序线索化方法
    public void threadedNodes(HeroNode node){
        //如果node==null，不能线索化
        if(node == null){
            return;
        }

        //线索化左子树
        threadedNodes(node.getLeft());
        //线索化当前节点
            //处理当前节点的前驱节点
            if(node.getLeft() == null){
                //让当前节点左指针指向前驱节点
                node.setLeft(pre);
                //修改当前节点的左指针类型
                node.setLeftType(1);
            }
            //处理后继节点
            if(pre != null && pre.getRight() == null){
                //前驱节点的右指针指向当前节点
                pre.setRight(node);
                //修改前驱节点的右指针类型
                pre.setRightType(1);
            }

            //每处理一个节点后，让当前节点是下一个节点的前驱节点
            pre = node;
        //线索化右子树
        threadedNodes(node.getRight());
    }

    //todo 前序中序线索化二叉树

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

class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    //0指向左子树,1代表指向前驱节点
    private int leftType;
    //0右子树,后继节点
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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


