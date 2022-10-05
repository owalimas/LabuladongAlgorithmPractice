package com.jungle.exam.lkyd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: 乐刻编程题 从0,1,2,...,n这n+1个数中选择n个数，组成有序数组，找出这n个数中缺失的那两个数数，要求O(n)尽可能小。
 * @author: Jungle 解决不连续的缺一万个数，但是连续缺数还没解决，最简单检查最大的数，和下标，然后在对数组进行比较
 * @createDate: 2022/8/27 23:25
 */
public class written {
    static ArrayList<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        String[] inArr = in.split(",");
        int[] arr = new int[inArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inArr[i]);
        }
        solve(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println(Arrays.toString(res.toArray()));


    }

    public static void solve(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        int start = a[0];
        for (int i = 1; i < a.length; i++) {
            //比较前后两个元素是否只相差一个，不是话说明缺失i+1，其实就是两个指针，一前一后往前走，遇到不满足就记录 O(n)
            if (a[i] - a[i - 1] != 1) {
                res.add(start + 1);
            }
            start = a[i];
        }
    }
}
