package com.atguigu.recursion;

/**
 * @author shkstart
 * @create 2022-06-26 14:15
 */
public class Queue8 {

    //定义max表示共有多少个皇后
    int max = 8;
    //定义数组，保存皇后位置，比如arr=【0,7,8】
    int [] array = new int[max];

    static int count = 0;

    public static void main(String[] args) {

        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d解法",count);
    }

    //放置第n个皇后
    private void check(int n){
        if(n == max){
            print();
            return;
        }

        for (int i = 0; i < max; i++) {
            array[n] = i;
            //判断当前放置第n个皇后到i列时，是否冲突
            if(judge(n)){
                check(n+1);
            }
        }
    }

    //查看当我们放置第n个皇后，检测该皇后是否和前面的皇后冲突

    /**
     *
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //array[i] == array[n] 判断din个皇后是否和前面的n-1个皇后在同一列
            //Math.abs(n-i) == Math.abs(array[n] - array[i]) 判断是否同一斜线
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }


    //打印皇后位置
    private void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "");
        }
        System.out.println();
    }
}
