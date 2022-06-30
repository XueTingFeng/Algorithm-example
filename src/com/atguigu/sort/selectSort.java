package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class selectSort {

    public static void main(String[] args) {
//        int arr[] = {101,34,119,1};
//        selectSort(arr);

        //测速
        int [] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);//[0,80000)
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = simpleDateFormat.format(date1);
        System.out.println(dateStr1);

        selectSort(arr);

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr2 = simpleDateFormat2.format(date2);
        System.out.println(dateStr2);
    }

    //选择排序
    public static void selectSort(int[] arr){

        //推导过程发现规律，嵌套循环


        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;
            int min = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                if(min > arr[j]){ //假定的最小值不是最小的
                    min = arr[j];
                    minIndex = j;//重置index
                }
            }

            //将最小值，放在arr【0】，即交换
            if(minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

//            System.out.println("第"+(i+1)+"轮排序");
//            System.out.println(Arrays.toString(arr));
        }




        //逐步推导
        //第一轮
        //原始数组：101,34,119,1
        //算法 先简单 --》 再复杂

        //第一轮 1,34,119,101
//        int minIndex = 0;
//        int min = arr[0];
//
//        for (int j = 0 + 1; j < arr.length; j++) {
//            if(min > arr[j]){ //假定的最小值不是最小的
//                min = arr[j];
//                minIndex = j;//重置index
//            }
//        }
//
//        //将最小值，放在arr【0】，即交换
//        arr[minIndex] = arr[0];
//        arr[0] = min;
//
//        System.out.println("第一轮后");
//        System.out.println(Arrays.toString(arr));
    }

}
