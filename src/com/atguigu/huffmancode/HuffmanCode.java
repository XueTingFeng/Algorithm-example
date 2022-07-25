package com.atguigu.huffmancode;

import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        //String content = "hello world";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);

        byte[] huffmanCodeBytes = huffmanZip(contentBytes);

        System.out.println(Arrays.toString(huffmanCodeBytes));

        byte[] sourceBytes = decode(huffmanCodes, huffmanCodeBytes);
        System.out.println(new String(sourceBytes));

//        List<Node> nodeList = getNodes(contentBytes);
//        System.out.println(nodeList);
//
//        //测试
//        System.out.println("赫夫曼树");
//        Node huffmanTreeRoot = createHuffmanTree(nodeList);
//        huffmanTreeRoot.preOrder();
//
//        System.out.println("");
//        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
//        System.out.println("赫夫曼编码表" + huffmanCodes);
//
//        byte[] zip = zip(contentBytes, huffmanCodes);
//        System.out.println(Arrays.toString(zip));
    }

    //对压缩数据的解码
    /**
     *
     * @param huffmanCodes 编码表
     * @param huffmanBytes 字节数组
     * @return 原来字符串对应的数组
     */
    private static byte[] decode(Map<Byte,String> huffmanCodes,byte[] huffmanBytes){

        StringBuilder stringBuilder = new StringBuilder();
        //将byte数组转成二进制字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            //判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag,b));
        }

        Map<String,Byte> map = new HashMap<String,Byte>();
        for (Map.Entry<Byte,String> entry:
             huffmanCodes.entrySet()) {
            map.put(entry.getValue(),entry.getKey());
        }

        List<Byte> list = new ArrayList<>();
        for(int i=0;i<stringBuilder.length();){
            int count = 1;
            boolean flag = true;
            Byte b = null;

            while (flag){
                String key = stringBuilder.substring(i,i+count);
                b = map.get(key);
                if(b == null){
                    count++;
                } else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }

        byte b[] = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }

        return b;
    }

    //解压
    /**
     *
     * @param flag 表示需要补高位
     * @param b 传入的byte
     * @return 对应的二进制的字符串
     */
    private static String byteToBitString(boolean flag,byte b){

        int temp = b;

        if(flag){
            temp |= 256;//按位异或
        }

        String str = Integer.toBinaryString(temp);//返回的temp是二进制的补码
        if(flag){
            return str.substring(str.length() - 8);
        } else {
            return str;
        }

    }

    //封装方法，便于调用
    /**
     *
     * @param bytes 原始字符串对应的字节数组
     * @return 压缩后的数组
     */
    private static byte[] huffmanZip(byte[] bytes){
        List<Node> nodeList = getNodes(bytes);
        Node huffmanTreeRoot = createHuffmanTree(nodeList);
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);

        return huffmanCodeBytes;
    }

    //将字符串对应的byte【】数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码，压缩后的byte【】
    /**
     *
     * @param bytes 原始字符串对应的byte[]
     * @param huffmanCodes 生成的赫夫曼编码map
     * @return 处理后的byte[]
     */
    private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        StringBuilder stringBuilder = new StringBuilder();

        for (byte b :
                bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }

        //System.out.println(stringBuilder);

        int len;
        if(stringBuilder.length() % 8 == 0){
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }

        //创建存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;//记录是第几个byte
        for (int i = 0; i < stringBuilder.length(); i+=8) {
            String strByte;
            if(i + 8 > stringBuilder.length()){
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i,i + 8);
            }

            huffmanCodeBytes[index] = (byte)Integer.parseInt(strByte,2);
            index++;
        }

        return huffmanCodeBytes;

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
