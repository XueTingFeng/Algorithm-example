package com.book.sort;

//插入排序
public class Insertion {
    public static void main(String[] args) {
        int N = 10;
        Double[] arr = new Double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Math.random();
        }
        sort(arr);
        boolean sorted = isSorted(arr);
        System.out.println(sorted);
        show(arr);
    }

    //进行排序
    public static void sort(Comparable[] a){
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j],a[j-1]); j--) {
                exch(a,j,j-1);
            }
        }
    }

    //判断谁大谁小
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0 ;
    }

    //交换元素
    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    //打印结果
    private static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
            System.out.println();
        }
    }

    //最终结果
    private static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }
}
