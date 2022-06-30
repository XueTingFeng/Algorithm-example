package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class insertSort {

    public static void main(String[] args) {
//        int []arr = {101,34,119,1};
//        insertSort(arr);

        //测速
        int [] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);//[0,80000)
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = simpleDateFormat.format(date1);
        System.out.println(dateStr1);

        insertSort(arr);

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr2 = simpleDateFormat2.format(date2);
        System.out.println(dateStr2);
    }

    //插入排序
    public static void insertSort(int[] arr){

        for (int i = 1; i < arr.length; i++) {
            //定义待插入数
            int insertVal = arr[i];
            int insertIndex = i - 1;//前面数的下标

            //找到插入的位置
            //保证找插入位置时，不越界       待插入数还未找到插入位置,需要将下标后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;

//            System.out.println("第"+i+"轮");
//            System.out.println(Arrays.toString(arr));
        }




        //逐步推导
        //第一轮 34,101,119,1

        //定义待插入数
//        int insertVal = arr[1];
//        int insertIndex = 1 - 1;//前面数的下标
//
//        //找到插入的位置
//        //保证找插入位置时，不越界       待插入数还未找到插入位置,需要将下标后移
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]){
//            arr[insertIndex + 1] = arr[insertIndex];
//            insertIndex--;
//        }
//        arr[insertIndex + 1] = insertVal;
//        System.out.println("第一轮插入后");
//        System.out.println(Arrays.toString(arr));
    }
}
