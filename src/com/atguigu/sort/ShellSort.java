package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {

    public static void main(String[] args) {
//        int arr[] = {8,9,1,7,2,3,5,4,6,0};
//        shellSort2(arr);

        //测速
        int [] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000);//[0,80000)
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = simpleDateFormat.format(date1);
        System.out.println(dateStr1);

        shellSort2(arr);

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr2 = simpleDateFormat2.format(date2);
        System.out.println(dateStr2);
    }

    //希尔排序
    public static void shellSort(int[] arr){
//        int temp = 0;
//        // 第一轮
//        //将十个数据分成5组
//        for (int i = 5; i < arr.length; i++) {
//            for (int j = i - 5; j >= 0; j-=5) {
//                //如果当前元素大于加上下标后的元素，说明交换
//                if(arr[j] > arr[j + 5]){
//                    temp = arr[j];
//                    arr[j] = arr[j+5];
//                    arr[j+5] = temp;
//                }
//            }
//        }
//        System.out.println("希尔排序第一轮" + Arrays.toString(arr));
//
//        //二
//        for (int i = 2; i < arr.length; i++) {
//            for (int j = i - 2; j >= 0; j-=2) {
//                //如果当前元素大于加上下标后的元素，说明交换
//                if(arr[j] > arr[j + 2]){
//                    temp = arr[j];
//                    arr[j] = arr[j+2];
//                    arr[j+2] = temp;
//                }
//            }
//        }
//        System.out.println("希尔排序第二轮" + Arrays.toString(arr));
//
//        //三
//        for (int i = 1; i < arr.length; i++) {
//            for (int j = i - 1; j >= 0; j-=1) {
//                //如果当前元素大于加上下标后的元素，说明交换
//                if(arr[j] > arr[j + 1]){
//                    temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
//        System.out.println("希尔排序第三轮" + Arrays.toString(arr));
//
        int temp = 0;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 第一轮
            //将十个数据分成5组
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j-=gap) {
                    //如果当前元素大于加上下标后的元素，说明交换
                    if(arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
                
            }
           //   System.out.println("希尔排序第" + (++count) + "轮:" +  Arrays.toString(arr));
        }
    }

    //移位法
    public static void shellSort2(int[] arr){
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j - gap]){
                    while (j - gap >= 0 && temp < arr[j-gap]){
                        //移动
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    //退出while，temp找到插入的位置
                    arr[j] = temp;
                }
            }
        }
        //System.out.println(Arrays.toString(arr));
    }
}
