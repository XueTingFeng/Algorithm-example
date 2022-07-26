package com.atguigu.binarysorttree;

/**
 * @author shkstart
 * @create 2022-07-26 19:37
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9,2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for(int i=0;i< arr.length;i++){
            binarySortTree.add(new Node(arr[i]));
        }

        System.out.println("中序遍历");
        binarySortTree.infixOrder();

        //测试删除叶子节点
//        binarySortTree.delNode(2);
//        System.out.println("删除节点后");
//        binarySortTree.infixOrder();

        //删除只有一颗子树的节点
//        binarySortTree.delNode(1);
//        System.out.println("删除节点后");
//        binarySortTree.infixOrder();

        //删除有两颗子树的节点
        binarySortTree.delNode(7);
        System.out.println("删除节点后");
        binarySortTree.infixOrder();
    }
}

//创建二叉排序树
class BinarySortTree{
    private Node root;

    //查找要删除的节点
    private Node search(int value){
        if(root == null){
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找要删除节点的父节点
    public Node searchParent(int value){
        if(root == null){
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     *
     * @param node 传入的节点 当做二叉排序树的根节点
     * @return 返回 以node 为根节点的二叉排序树的最小节点的值
     */
    public int delRightTreeMin(Node node){
        Node target = node;

        //循环查找左节点,就会找到最小值
        while (target.left != null){
            target = target.left;
        }

        //这时target就指向了最小节点
        delNode(target.value);

        return target.value;
    }

    //todo 左子树找最大的

    //删除节点
    public void delNode(int value){
        if(root == null){
            return;
        } else {
            Node targetNode = search(value);
            //如果没有找到节点
            if(targetNode == null){
                return;
            }

            //如果发现只有一个节点
            if(root.left == null && root.right == null){
                root = null;
                return;
            }

            //查找targetNode的父节点
            Node parent = searchParent(value);
            //如果删除的节点是叶子结点
            if(targetNode.left == null && targetNode.right == null){
                //判断targetNode 是父节点的左子节点 还是 右子节点
                if(parent.left != null && parent.left.value == value){
                    parent.left = null;
                } else if(parent.right != null && parent.right.value == value){
                    parent.right = null;
                }
            } else if(targetNode.left != null && targetNode.right != null){//删除有两颗子树的节点
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            } else {//删除只有一颗子树的节点
                //如果要删除的节点有左子节点
                if(targetNode.left != null){
                    //如果targetNode 是 parent 的左子节点
                    if(parent.left.value == value){
                        parent.left = targetNode.left;
                    } else { //如果是右子节点
                        parent.right = targetNode.left;
                    }
                } else {//如果要删除的节点有右子节点
                    if(parent.left.value == value){
                        parent.left = targetNode.right;
                    } else { //如果是右子节点
                        parent.right = targetNode.right;
                    }
                }
            }
        }
    }



    //添加节点方法
    public void add(Node node){
        if(root == null){
            root = node;
        } else {
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder(){
        if(root != null){
            root.infixOrder();
        } else {
            System.out.println("二叉树为空，不能遍历");
        }
    }

}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }


    /**
     * 查找要删除的节点
     * @param value 希望删除节点的值
     * @return 找到该节点返回该节点，否则返回null
     */
    public Node search(int value){
        if(value == this.value){//找到该节点
            return this;
        } else if(value < this.value){//如果查找的值小于当前节点，向左子树递归查找
            if(this.left == null){
                return null;
            }
            return this.left.search(value);
        } else {
            if(this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     *
     * @param value 要删除节点的值
     * @return 返回要删除节点的父节点,没有则返回null
     */
    public Node searchParent(int value){
        //当前节点就是要删除节点的父节点
        if((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)){
            return this;
        } else {
            //如果查找的值小于当前节点的值，并且当前左子节点不为空
            if(value < this.value && this.left != null){
                return this.left.searchParent(value);
            } else if(value >= this.value && this.right != null){
                return this.right.searchParent(value);
            } else {
                return null;//没有父节点
            }
        }
    }



    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //添加节点
    //递归形式添加节点，需要满足二叉排序树
    public void add(Node node){
        if(node == null){
            return;
        }

        //判断传入的节点值，和当前子树根节点值的关系
        if(node.value < this.value){
            //如果当前节点左子节点为null
            if(this.left == null){
                this.left = node;
            } else {
                this.left.add(node);
            }

        } else {
            if(this.right == null){
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    //中序遍历
    public void infixOrder(){
        if(this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.infixOrder();
        }
    }
}

