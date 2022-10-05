package com.jungle.easy.day03;

/**
 * @Description 差分数组工具类
 * 1.构建差分数组（编码）
 * 2.差分数组的区域加减（计算）
 * 3.差分数组返回原数组（解码）
 * @Author Jungle
 * @DATE 2022/5/16
 **/
public class Difference {
    private int[] diff;

    public Difference(int[] nums) {
        diff = new int[nums.length];
        //与前缀和不同，差分数组第一个元素就是原数组的第一个值
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    //差分数组，区间[l,r]上的加减
    public void increment(int l, int r, int val) {
        diff[l] += val;
        if (r + 1 < diff.length) {
            diff[r + 1] -= val;
        }
    }

    public int[] result() {
        int[] res = new int[this.diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = diff[i] + res[i - 1];
        }
        return res;
    }

}
