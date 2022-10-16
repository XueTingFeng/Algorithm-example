package com.leetcode.sort;

/**
 * @author shkstart
 * @create 2022-10-17 0:24
 */
public class Sort {
    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums,0,nums.length-1,temp);
        return nums;
    }

    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left < right){
            int mid = (left + right) / 2;
            //向左递归分解
            mergeSort(arr,left,mid,temp);
            //向右
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);

        }
    }

    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;

        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
                temp[t] = arr[i];
                i++;
                t++;
            }else{
                temp[t] = arr[j];
                j++;
                t++;
            }
        }

        while(i <= mid){
            temp[t] = arr[i];
            i++;
            t++;
        }

        while(j <= right){
            temp[t] = arr[j];
            j++;
            t++;
        }

        t = 0;
        int tempLeft = left;
        while(tempLeft <= right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
