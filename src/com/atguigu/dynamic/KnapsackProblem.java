package com.atguigu.dynamic;

/**
 * @author shkstart
 * @create 2022-08-09 20:54
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1,4,3};//物品的重量
        int[] val = {1500,3000,2000};//物品的价值
        int m = 4;//背包容量
        int n = val.length;//物品的个数




        //创建二维数组，表
        int[][] v = new int[n+1][m+1];
        //记录放入商品的情况
        int[][] path = new int[n+1][m+1];

        //初始化第一行和第一列
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;//第一列设置为0
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;//第一行设置为0
        }

        //根据公式来动态规划处理
        for (int i = 1; i < v.length; i++) { //不处理第一行
            for (int j = 1; j < v[0].length; j++) {
                //公式
                if(w[i-1] > j){ //i从1开始，原来公式中的w[i] 改 w[i-1]
                    v[i][j] = v[i-1][j];
                } else {
                    //v[i][j] = Math.max(v[i-1][j], val[i-1]+v[i-1][j-w[i-1]]);

                    if(v[i-1][j] < val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j] =  val[i-1]+v[i-1][j-w[i-1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i-1][j];
                    }
                }
            }
        }


        //打印
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        //输出放入那些商品
//        for (int i = 0; i < path.length; i++) {
//            for (int j = 0; j < path[i].length; j++) {
//                if(path[i][j] == 1){
//                    System.out.printf("第%d个商品放入到背包\n",i);
//                }
//            }
//        }

        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0){
            if(path[i][j] == 1){
                System.out.printf("第%d个商品放入到背包\n",i);
                j -= w[i-1];
            }
            i--;
        }
    }
}
