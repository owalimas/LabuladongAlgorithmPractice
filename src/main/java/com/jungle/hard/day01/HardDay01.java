package com.jungle.hard.day01;

import org.junit.Test;

import java.util.*;

/**
 * @Description Day01. 图论算法基础
 * 797. 所有可能的路径
 * @Author Jungle
 * @DATE 2022/7/12
 **/

public class HardDay01 {

    public static void main(String[] args) {
        int value = 15;
        int aa = 2;
        int res = (value + aa -1) & ~(aa-1);
        System.out.println(res);
    }
    static int ans;
    public static int fib (int n) {
        if (n <= 2) {
            ans++;
            return 1;
        }
        else {
            return (fib(n - 1) + fib (n - 2));
        }
    }

    int res;
    public int maximumTotal(int[][] triangle){
        if(triangle.length == 0){
            return 0;
        }
        traverse(triangle,0,0);
        return res + triangle[0][0];
    }
    public int traverse(int[][] triangle, int i, int j){
        if(i >triangle.length - 1 || j > triangle[i].length || i < 0 || j < 0){
            return 0;
        }
        int left = traverse(triangle,i + 1,j);
        int right = traverse(triangle,i + 1,j + 1);
        int maxVal = Math.max(left,right);
        res = Math.max(res,Math.max(left,right));
        return maxVal + triangle[i][j];
    }
    @Test
    public  void  test(){
        int[][] triangle = new int[][]{{1},{2,3},{4,5,6},{20,6,7,9}};
        int result = maximumTotal(triangle);
        System.out.println(result);
    }



}
