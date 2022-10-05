package com.jungle.easy.day03;

/**
 * @Description Day03. 差分数组技巧
 * 1.1109. 航班预订统计
 * 2.1094. 拼车
 * @Author Jungle
 * @DATE 2022/5/14
 **/
public class PracticeDay03 {



    //航班预订统计
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference Difference = new Difference(nums);
        //bookings中的元素需要分解出
        for (int i = 0; i < bookings.length; i++) {
            //题目描述的是第i条，而构造差分数组时，下标从0开始
            Difference.increment(bookings[i][0] - 1, bookings[i][1] - 1, bookings[i][2]);
        }
        return Difference.result();
    }

    //拼车
    public boolean carPooling(int[][] trips, int capacity) {
        //最大1001个车站
        int[] nums = new int[1001];
        Difference dif = new Difference(nums);
        for (int[] trip : trips) {
            int val = trip[0];
            //相当于差分数组中的区间,需要注意的是区间范围，i处上车，j处下车
            int i = trip[1];
            int j = trip[2] - 1;
            dif.increment(i, j, val);
        }
        int[] res = dif.result();
        for (int val : res) {
            if (val > capacity) {
                return false;
            }
        }
        return true;
    }


}
