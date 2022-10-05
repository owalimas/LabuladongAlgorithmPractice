package com.jungle.exam.lkyd;

import java.util.Arrays;

/**
 * @Description 乐刻运动一面手撕
 * @Author Jungle
 * @DATE 2022/10/5
 **/
public class Interview01 {
    //实现两个有序数组合并
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,5,7,9};
        int[] arr2 = new int[]{2,4,6,8,10};
        int[] ints = mergeArr(arr1, arr2);
        System.out.println(Arrays.toString(ints));
    }

    public static  int[] mergeArr(int[] arr1,int[] arr2){
        //定义两个指针
        int i = 0, j = 0;
        //分别遍历两个数组，存放到辅助数组
        int[] res = new int[arr1.length + arr2.length];
        int index = 0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                res[index] = arr1[i];
                i++;
            }else{
                res[index] = arr2[j];
                j++;
            }
            index++;
        }
        //
        while(i < arr1.length){
            res[index] = arr1[i];
            i++;
            index++;
        }
        while(j < arr2.length){
            res[index] = arr2[j];
            index++;
            j++;
        }
        return res;
    }

}
