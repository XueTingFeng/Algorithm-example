package com.atguigu.horse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author shkstart
 * @create 2022-09-06 20:15
 */
public class HorseChessboard {

    private static int X;//棋盘的列数
    private static int Y;//棋盘的行数

    private static boolean visited[];//标记位置是否访问过
    private static boolean finished;

    public static void main(String[] args) {
        //测试
        X=8;
        Y=8;
        int row = 1;
        int colum = 1;
        //创建棋盘
        int[][] chessboard = new int[X][Y];
        visited = new boolean[X * Y];//初始值都是false

        long start = System.currentTimeMillis();
        trgaversalChessborad(chessboard,row-1,colum-1,1);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        for (int[] rows :
                chessboard) {
            for (int step :
                    rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param chessboard 棋盘
     * @param row   马当前位置的行
     * @param colum 当前位置列
     * @param step  是第几步
     */
    public static void trgaversalChessborad(int[][] chessboard,int row,int colum,int step){
        chessboard[row][colum] = step;
        visited[row * X + colum] = true;//标记位置已经被访问
        //获取当前位置可以走的下一个位置的集合
        ArrayList<Point> ps = next(new Point(colum, row));
        //对ps下一步所有位置进行排序
        sort(ps);
        //遍历ps
        while (!ps.isEmpty()){
            Point p = ps.remove(0);//取出下一个可以走的位置
            //判断该点是否已经访问过
            if(!visited[p.y * X + p.x]){//说明还没有访问过
                trgaversalChessborad(chessboard,p.y,p.x,step + 1);
            }
        }

        if(step < X * Y && !finished){
            chessboard[row][colum] = 0;
            visited[row * X + colum] = false;
        } else {
            finished = true;
        }
    }

    public static ArrayList<Point> next(Point curPoint){
        //创建ArrayList
        ArrayList<Point> ps = new ArrayList<>();

        Point p1 = new Point();
        if((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0){
            ps.add(new Point(p1));
        }

        if((p1.x = curPoint.x - 1) >= 0 && (p1.y= curPoint.y-2)>=0){
            ps.add(new Point(p1));
        }

        if((p1.x=curPoint.x+1) < X && (p1.y=curPoint.y-2)>=0){
            ps.add(new Point(p1));
        }

        if((p1.x=curPoint.x+2) < X && (p1.y=curPoint.y-1)>=0){
            ps.add(new Point(p1));
        }

        if((p1.x=curPoint.x+2) < X && (p1.y=curPoint.y+1)<Y){
            ps.add(new Point(p1));
        }

        if((p1.x=curPoint.x+1) < X && (p1.y=curPoint.y+2)<Y){
            ps.add(new Point(p1));
        }

        if((p1.x=curPoint.x-1) >= 0 && (p1.y=curPoint.y+2)<Y){
            ps.add(new Point(p1));
        }

        if((p1.x=curPoint.x-2) >= 0 && (p1.y=curPoint.y+1)<Y){
            ps.add(new Point(p1));
        }
        return ps;
    }

    //根据当前这一步的所有下一步选择位置，进行非递减排序
    public static void sort(ArrayList<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                //获取o1的下一步的所有位置个数
                int count1 = next(o1).size();
                int count2 = next(o2).size();
                if(count1 < count2){
                    return -1;
                } else if(count1 == count2){
                    return 0;
                } else {
                    return 1;
                }
            }
        });
    }

}
