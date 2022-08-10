package com.atguigu.kmp;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2022-08-10 20:09
 */
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

        int[] next = kmpnext("ABCDABD");
        System.out.println(Arrays.toString(next));

        int i = kmpSearch(str1, str2, next);
        System.out.println(i);
    }

    /**
     * kmp搜索算法
     * @param str1 原字符串
     * @param str2 子串
     * @param next 部分匹配表
     * @return -1没有匹配到，否则返回第一个匹配的位置
     */
    public static int kmpSearch(String str1,String str2,int[] next){
        for (int i = 0,j = 0; i < str1.length(); i++) {

            //需要处理不相等的情况
            while (j > 0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j-1];
            }

            if(str1.charAt(i) == str2.charAt(j)){
                j++;
            }

            if(j == str2.length()){
                return i - j + 1;
            }
        }
        return -1;
    }

    //获取到一个字符串的部分匹配表
    public static int[] kmpnext(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;//如果字符串长度为1，部分匹配值就是0
        for (int i = 1,j = 0; i < dest.length(); i++) {

            //不满足,需要从next[j-1]获取新的j
            //直到发现条件满足退出
            while (j > 0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j-1];
            }

            //满足时,部分匹配值+1
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
