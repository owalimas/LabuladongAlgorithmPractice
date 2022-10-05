package com.jungle.exam;

import java.util.*;

/**
 * @Description 微派 全排列、树的序列化与反序列化
 * @DATE 2022/9/18
 **/
public class wp {

    //**************************全排列start******************************
    /*
    //因为输入包含重复数字用Set去重
    public static HashSet<LinkedList<Integer>> res;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //输入1 3 3 4 5
        String in = scanner.nextLine();
        String[] s = in.split(" ");
        int[] inNums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            inNums[i] = Integer.parseInt(s[i]);
        }
//        for (int i = 0; i < s.length; i++) {
//            System.out.print(nums[i]);
//        }
        Arrays.sort(inNums);
        //去重全排列
        //int[] nums = removeCopy(inNums);
        //全排列后去重
        int[] nums = inNums;
        System.out.println(Arrays.toString(nums));
        //处理：先选择，然后从3 3 4 5 中选择，确定3 在 3 4 5中选择，
        // 类似遍历 二叉树，当第一条树的路径确定后，需要回溯，选择另外的路径
        int[] used = new int[nums.length];
        res = new HashSet<LinkedList<Integer>>();
        LinkedList<Integer> midRes = new LinkedList<>();
        backtrace(nums, used, midRes);
        System.out.println(Arrays.toString(res.toArray()));
    }
    //回溯法 0.做选择 1.递归探索 2.回溯撤销选择 注：需要记录中间结果，选择前，判断之前步骤选过哪些，不能再选
    public static void backtrace(int[] nums, int[] used, LinkedList midRes) {
        //排列已满
        if (midRes.size() == nums.length) {
            res.add(new LinkedList<>(midRes));
            return;
        }
        //0.做选择
        for (int i = 0; i < nums.length; i++) {
            //已选择过，继续下一次选择
            if (used[i] == 1) {
                continue;
            }
            //做选择
            used[i] = 1;
            midRes.add(nums[i]);
            //递归探索
            backtrace(nums, used, midRes);
            //回溯撤销
            used[i] = 0;
            //去除上一次末尾的选择
            midRes.removeLast();
        }
    }
    //数组去重 HashMap
    public static int[] removeCopy(int[] nums) {
        int n = nums.length;
        LinkedList<Integer> res = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }else{
                map.put(nums[i],1);
                res.add(nums[i]);
            }
        }
        int[] resArr = new int[res.size()];
        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
    */
    //**************************全排列end**********************************

    //**************************树的序列化与反序列化******************************

    public static void main(String[] args) {

    }



}
