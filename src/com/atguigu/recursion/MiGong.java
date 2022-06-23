package com.atguigu.recursion;

public class MiGong {

    public static void main(String[] args) {
        int[][] map = new int[8][7];

        //使用1表示墙
        //上下设置1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        //左右设置1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;

        System.out.println("地图的情况：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //使用递归回溯给小球找路
        setWay(map,1,1);

        //输出新地图，小球走过，并标识过的地图
        System.out.println("新地图的情况：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


    //下-右-上-左
    /**
     *
     * @param map 表示地图
     * @param i 开始位置
     * @param j 找的位置
     * @return 如果找到路，就返回true,否则返回false
     */
    public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5] == 2){
            return true;
        } else {
            if(map[i][j] == 0){
                map[i][j] = 2;//假定该点可以走通
                if(setWay(map,i+1,j)){
                    return true;
                } else if (setWay(map,i,j+1)){
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if(setWay(map,i,j-1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    //修改策略
    public static boolean setWay2(int[][] map,int i,int j){
        if(map[6][5] == 2){
            return true;
        } else {
            if(map[i][j] == 0){
                map[i][j] = 2;//假定该点可以走通
                if(setWay(map,i - 1,j)){
                    return true;
                } else if (setWay(map,i,j + 1)){
                    return true;
                } else if (setWay(map, i + 1, j)) {
                    return true;
                } else if(setWay(map,i,j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
