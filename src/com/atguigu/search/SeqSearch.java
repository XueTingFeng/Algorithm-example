package com.atguigu.search;

public class SeqSearch {

    public static void main(String[] args) {
        int[] arr = {1,9,11,-1,34,89};
        int index = seqSearch(arr,11);
        if(index == -1){
            System.out.println("没有找到");
        }else{
            System.out.println("下标为：" + index);
        }

    }

    /**
     *  找到一个满足条件的值
     * @param arr
     * @param val
     * @return
     */
    public static int seqSearch(int[] arr,int val){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == val){
                return i;
            }
        }
        return -1;
    }

}
