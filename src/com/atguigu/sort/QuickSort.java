package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author shkstart
 * @create 2022-07-03 19:33
 */
public class QuickSort {

    public static void main(String[] args) {
//        int [] arr = {70,-9,78,0,23,-567,70,70};
//        quickSort2(arr,0,arr.length-1);

        int [] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);//[0,80000)
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = simpleDateFormat.format(date1);
        System.out.println(dateStr1);

        quickSort2(arr,0,arr.length-1);

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr2 = simpleDateFormat2.format(date2);
        System.out.println(dateStr2);

        System.out.println(Arrays.toString(arr));


    }

    public static void quickSort(int [] arr,int left,int right){
        int l = left;//左下标
        int r = right;//右下标

        int pivot = arr[(left + right) / 2];
        int temp = 0;

        while (l < r){

            //在左边一直找，找到大于等于中间的值，才退出
            while (arr[l] < pivot){
                l += 1;
            }

            //找右边
            while (arr[r] > pivot){
                r -= 1;
            }

            if(l >= r){
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //交换完，发现arr[l] == pivot值 相等,前移
            if(arr[l] == pivot){
                r -= 1;
            }

            if(arr[r] == pivot){
                l += 1;
            }

        }

        //如果l == r,必须l++,r--,否则栈溢出
        if(l == r){
            l += 1;
            r -= 1;
        }

        //向左递归
        if(left < r){
            quickSort(arr,left,r);
        }

        if(right > l){
            quickSort(arr,l,right);
        }

    }


    //听得不是很明白，自己写一遍
    public static void quickSort2(int[] arr,int left,int right){

        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];

        int temp = 0;

        while (l < r){

            while(arr[l] < pivot){
                l++;
            }

            while(arr[r] > pivot){
                r--;
            }

            if(l == r){
                l += 1;
                r -= 1;
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //发现相同，避免死循环，因为已经交换过，所以 r--
            if(arr[l] == pivot){
                r -= 1;
            }

            if(arr[r] == pivot){
                l += 1;
            }

        }

        //向左递归
        if(left < r){
            quickSort2(arr,left,r);
        }

        if(right > l){
            quickSort2(arr,l,right);
        }
    }


}
