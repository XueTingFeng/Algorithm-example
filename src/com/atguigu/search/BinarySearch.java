package com.atguigu.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1234};
        int resIndex = binarySearch(arr,0, arr.length - 1, 1234);
        System.out.println("resIndex=" + resIndex);

        int[] arr2 = {1,8,10,89,1000,1000,1000,1234};
        List<Integer> resIndexList = binarySearch2(arr2,0, arr.length - 1, 1000);
        System.out.println("resIndexList=" + resIndexList);
    }

    /**
     *
     * @param arr 数组
     * @param left 左边的索引
     * @param right 右边的索引
     * @param findVal 要找的值
     * @return 找到返回下标，否则返回-1
     */
    public static int binarySearch(int[] arr,int left,int right,int findVal){

        if(left > right){
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if(findVal > midVal){
            return binarySearch(arr,mid + 1,right,findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr,left,mid - 1,findVal);
        } else{
            return mid;
        }

    }

    //返回多个重复的值
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal){

        if(left > right){
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if(findVal > midVal){
            return binarySearch2(arr,mid + 1,right,findVal);
        } else if (findVal < midVal) {
            return binarySearch2(arr,left,mid - 1,findVal);
        } else{

            List<Integer> resIndexList = new ArrayList<>();
            int temp = mid - 1;
            while (true){
                if(temp < 0 || arr[temp] != findVal){
                    break;
                }
                //temp放入集合
                resIndexList.add(temp);
                temp-=1;
            }
            resIndexList.add(mid);

            temp = mid + 1;
            while (true){
                if(temp > arr.length - 1 || arr[temp] != findVal){
                    break;
                }
                //temp放入集合
                resIndexList.add(temp);
                temp+=1;
            }
            return resIndexList;
        }

    }
}
