package com.jungle.easy.day07;

import java.util.ArrayDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Description Day07. 前缀和数组技巧
 * 1.[303. 区域和检索 - 数组不可变]
 * 2.[304. 二维区域和检索 - 矩阵不可变]
 * @Author Jungle
 * @DATE 2022/5/18
 **/
public class PracticeDay07 {
    //1.[303. 区域和检索 - 数组不可变](https://leetcode-cn.com/problems/range-sum-query-immutable/) 【一维前缀和】
    class NumArray {

        //前缀和数组
        private int[] preSum;
        //构造前缀和数组
        public NumArray(int[] nums) {
            preSum = new int[nums.length + 1];
            //preSum 从1位置起计算，0位置等于直接等于0
            //这样计算0-0位置的时候也合理 preSum[1] - preSum[0]
            for (int i = 1; i < nums.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }
    }


    //2.  [304. 二维区域和检索 - 矩阵不可变](https://leetcode-cn.com/problems/range-sum-query-2d-immutable/)2. 【二维前缀和】
    class NumMatrix {
        private int[][] preSum;

        public NumMatrix(int[][] matrix) {
            //排除传入空矩阵
            int row = matrix.length;
            int col = matrix[0].length;
            if (row == 0 || col == 0) {
                return;
            }
            preSum = new int[row + 1][col + 1];
            //这里按照的是，preSum的维度去遍历,如图
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= col; j++) {
                    preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum[row2 + 1][col2 + 1] - preSum[row2 + 1][col1] - preSum[row1][col2 + 1] + preSum[row1][col1];
        }
    }
}
