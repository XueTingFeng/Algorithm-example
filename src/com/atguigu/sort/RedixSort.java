package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RedixSort {

    public static void main(String[] args) {
//        int[] arr = {53,3,542,748,14,214};
//        radixSort(arr);

        int [] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);//[0,80000)
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = simpleDateFormat.format(date1);
        System.out.println(dateStr1);

        int[] temp = new int[arr.length];
        radixSort(arr);

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr2 = simpleDateFormat2.format(date2);
        System.out.println(dateStr2);

        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr){
        //定义二维数组，，表示10个桶，每个桶就是一个一维数组
        //防止数据溢出，大小定位arr。length
        //空间换时间的算法
//        int[][] bucket = new int[10][arr.length];
//        //记录每个桶中，实际存放了多少个数据，记录的就是 bucket[0]桶的放入数据的个数
//        int[] bucketElementCounts = new int[10];
//        //第一轮（针对每个元素的个位进行排序处理）
//        for (int j = 0; j < arr.length; j++) {
//            //取出每个元素个位的值
//            int digitOfElement = arr[j] % 10;
//            //放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//        //放回原来的数组
//        int index = 0;
//        for (int k = 0; k < bucketElementCounts.length; k++) {
//            //如果桶中有数据，才放回原数组
//            if(bucketElementCounts[k] != 0){
//                for(int l = 0;l < bucketElementCounts[k];l++){
//                    arr[index++] = bucket[k][l];
//                }
//            }
//        }
       // System.out.println(Arrays.toString(arr));
        int[][] bucket = new int[10][arr.length];
        //记录每个桶中，实际存放了多少个数据，记录的就是 bucket[0]桶的放入数据的个数
        int[] bucketElementCounts = new int[10];

        int max = arr[0];//假设第一个数就是最大数
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        for (int i = 0, n = 1; i < maxLength; i++,n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素个位的值
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //放回原来的数组
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据，才放回原数组
                if(bucketElementCounts[k] != 0){
                    for(int l = 0;l < bucketElementCounts[k];l++){
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketElementCounts[k] = 0;
            }
            //System.out.println("第" + (i + 1)  + "轮" + Arrays.toString(arr));
        }
    }
}
