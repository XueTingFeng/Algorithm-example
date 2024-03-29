package com.atguigu.kruskal;


import java.util.Arrays;

/**
 * @author shkstart
 * @create 2022-08-27 19:27
 */
public class Kruskal {

    private int edgeNum;//边的个数
    private char[] vertexs;//顶点的个数
    private int[][] matrix;//邻接矩阵
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A','B','C','D','E','F','G'};

        int[][] matrix = {
                {0,12,INF,INF,INF,16,14},
                {12,0,10,INF,INF,7,INF},
                {INF,10,0,3,5,6,INF},
                {INF,INF,3,0,4,INF,INF},
                {INF,INF,5,4,0,2,8},
                {16,7,6,INF,2,0,9},
                {14,INF,INF,INF,8,9,0},
        };

        Kruskal kruskal = new Kruskal(vertexs, matrix);
        kruskal.print();
//
//        EData[] edges = kruskal.getEdges();
//        System.out.println("排序前=" + Arrays.toString(edges));
//        kruskal.sortEdge(edges);
//        System.out.println("排序后=" + Arrays.toString(edges));
        kruskal.kruskal();
    }

    //构造器
    public Kruskal(char[] vertexs, int[][] matrix) {
        //初始化顶点数和边的个数
        int vlen = vertexs.length;

        //初始化顶点
        this.vertexs = new char[vlen];
        for (int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        }

        //初始化边
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }

        //统计边
        for (int i = 0; i < vlen; i++) {
            for (int j = i+1; j < vlen; j++) {
                if(this.matrix[i][j] != INF){
                    edgeNum++;
                }
            }
        }
    }

    public void kruskal(){
        int index = 0;//表示最后结果数组的索引
        int[] ends = new int[edgeNum];//用于保存"已有最小生成树"每个顶点最小生成树的终点
        //创建结果数组，保存最后的最小生成树
        EData[] rets = new EData[edgeNum];

        //获取图中所有的边的集合，一共有12条边
        EData[] edges = getEdges();
        System.out.println("图的边的集合=" +  Arrays.toString(edges) + "共" + edges.length);

        //按照边的权值大小排序
        sortEdge(edges);

        //遍历edges数组,判断准备加入的边是否构成回路
        for (int i = 0; i < edgeNum; i++) {
            //获取第i条边的第一个顶点
            int p1 = getPosition(edges[i].start);
            //获取第i条边的第二个顶点
            int p2 = getPosition(edges[i].end);

            //获取p1这个顶点在已有的最小生成树中的终点
            int m = getEnd(ends,p1);
            //p2
            int n = getEnd(ends,p2);
            //是否构成回路
            if(m != n){
                ends[m] = n;//设置m 在已有最小生成树的终点
                rets[index++] = edges[i];//有一条边加入到数组
            }
        }
        for (int i = 0; i < index; i++) {
            System.out.println(rets[i]);
        }

    }

    //打印邻接矩阵
    public void print(){
        System.out.println("邻接矩阵:\n");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%10d\t",matrix[i][j]);
            }
            System.out.println();
        }
    }


    /**
     * 对边进行排序处理,冒泡排序
     * @param edges
     */
    private void sortEdge(EData[] edges){
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if(edges[j].weight > edges[j+1].weight){
                    EData tmp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = tmp;
                }
            }
        }
    }

    /**
     *
     * @param ch 顶点的值
     * @return  返回ch对应的下标，找不到返回-1
     */
    private int getPosition(char ch){
        for (int i = 0; i < vertexs.length; i++) {
            if(vertexs[i] == ch){
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取图中的边,放到EData[]数组中，后面遍历该数组
     * @return
     */
    private EData[] getEdges(){
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i+1; j < vertexs.length; j++) {
                if(matrix[i][j] != INF){
                    edges[index++] = new EData(vertexs[i],vertexs[j],matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 获取下标为i的顶点的终点,判断两个顶点的终点是否相同
     * @param ends 记录各个顶点对应的终点是哪个
     * @param i 传入的顶点对应下标
     * @return 返回就是下标为i的这个顶点对应的终点的下标
     */
    private int getEnd(int[] ends,int i){
        while (ends[i] != 0){
            i = ends[i];
        }
        return i;
    }
}

//对象实例表示一条边
class EData{
    char start;//边的一个点
    char end;//边的另外一个点
    int weight;//边的权值

    //构造器

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{<" +
                 start + "," +
                 end + ">=" +
                 weight +
                '}';
    }
}
