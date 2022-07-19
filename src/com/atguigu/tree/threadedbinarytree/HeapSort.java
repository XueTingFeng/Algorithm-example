package com.atguigu.tree.threadedbinarytree;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4,6,8,5,9};
        heapSort(arr);
    }

    //堆排序方法
    public static void heapSort(int arr[]){
        System.out.println("堆排序");
        int temp = 0;

        //分步
//        adjustHeap(arr,1,arr.length);
//        System.out.println("第一次排序" + Arrays.toString(arr));
//
//        adjustHeap(arr,0,arr.length);
//        System.out.println("第一次排序" + Arrays.toString(arr));
//
        //
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr,i, arr.length);
        }

        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }

        System.out.println(Arrays.toString(arr));
    }

    //将数组(二叉树),调整成大顶堆

    /**
     *  功能: i对应的非叶子节点的数调整成大顶堆
     *  int arr[]={4,6,8,5,9} => i=1 => adjustHeap => result:{4,9,8,5,6}
     *  i=0 {4,9,8,5,6} => {9,6,8,5,4}
     * @param arr 待调整数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 表示多少个元素继续调整,length 是在逐渐减少
     */
    public static void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];//取出当前元素的值，保存在临时变量

        //k = i * 2 + 1 k是i的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if(k + 1 < length && arr[k] < arr[k+1]){ //左子节点的值小于右子节点的值
                k++;//k 指向右子节点
            }
            if(arr[k] > temp){ //如果子节点大于父节点
                arr[i] = arr[k]; //把较大的值赋给当前节点
                i = k; //i指向k，继续循环比较
            } else {
                break;
            }
        }
        //当循环结束后，我们已经将以i为父节点树的最大值，放在了最顶（局部）
        arr[i] = temp;//将temp值放到调整后的位置
    }
}
