package com.book.sort;

import java.sql.Array;

/**
 * @author shkstart
 * @create 2022-10-10 20:09
 */
public class Merge {

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

    private static Comparable[] aux;

    public static void sort(Comparable a[]){
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    public static void sort(Comparable a[],int lo,int hi){
        if(hi <= lo){
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    public static void merge(Comparable a[],int lo,int mid,int hi){
        int i = lo, j = mid + 1;
        for(int k=lo;k <= hi;k++){
            aux[k] = a[k];
        }
        for(int k=lo;k<=hi;k++){
            if(i>mid){
                a[k] = aux[j++];
            } else if(j > hi){
                a[k] = aux[i++];
            } else if(less(aux[j],aux[i])){
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0 ;
    }

    private static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
            System.out.println();
        }
    }

    private static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }
}
