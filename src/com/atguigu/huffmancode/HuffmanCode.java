package com.atguigu.huffmancode;

import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);

        List<Node> nodeList = getNodes(contentBytes);
        System.out.println(nodeList);

        //测试
        System.out.println("赫夫曼树");
        Node huffmanTreeRoot = createHuffmanTree(nodeList);
        huffmanTreeRoot.preOrder();

        System.out.println("");
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        System.out.println("赫夫曼编码表" + huffmanCodes);
    }

    static Map<Byte,String> huffmanCodes = new HashMap<Byte,String>();

    static StringBuilder stringBuilder = new StringBuilder();

    //重载getcodes
    private static Map<Byte,String> getCodes(Node root){
        if(root == null){
            return null;
        }
        getCodes(root.left,"0",stringBuilder);
        getCodes(root.right,"1",stringBuilder);
        return huffmanCodes;
    }

    /**
     *
     * @param node 传入的节点
     * @param code 路径:左子节点是0，右子节点是1
     * @param stringBuilder 是用于拼接路径
     */
    private static void getCodes(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);

        stringBuilder2.append(code);
        if(node != null){
            if(node.data == null){
                getCodes(node.left,"0",stringBuilder2);

                getCodes(node.right,"1",stringBuilder2);
            } else {
                huffmanCodes.put(node.data,stringBuilder2.toString());
            }
        }
    }

    public static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        } else {
            System.out.println("树为空");
        }
    }

    /**
     *
     * @param bytes 接收字节数组
     * @return 返回list形式
     */
    private static List<Node> getNodes(byte[] bytes){

        ArrayList<Node> nodes = new ArrayList<Node>();

        Map<Byte,Integer> counts = new HashMap<>();
        for (byte b :
                bytes) {
            Integer count = counts.get(b);
            if(count == null){
                counts.put(b,1);
            } else {
                counts.put(b,count + 1);
            }
        }

        for (Map.Entry<Byte,Integer> entry : counts.entrySet()){
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }

        return nodes;
    }

    private static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size() > 1){
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null,leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(parent);
        }

        return nodes.get(0);
    }
}

//创建node，待数据和权值
class Node implements Comparable<Node>{
    Byte data;//存放数据本身
    int weight;//权值，表示字符出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node[" +
                "data=" + data +
                ", weight=" + weight + "]";
    }

    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }

}
