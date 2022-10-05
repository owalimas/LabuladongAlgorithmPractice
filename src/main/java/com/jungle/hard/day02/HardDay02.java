package com.jungle.hard.day02;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

/**
 * @Description Day02. 二分图判定算法
 * 785. 判断二分图
 * @Author Jungle
 * @DATE 2022/7/12
 **/
public class HardDay02 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        Date date = new Date();
        int x = in.nextInt();
        StringBuilder sb = new StringBuilder();

        while(x>0){
            int v = (int) Math.floor(Math.log(x) / Math.log(2));
            int temp = 1 << v;
            sb.append((char)('a'+v));
            x-=temp;
        }
        Date date2 = new Date();
        long nano = date2.getTime() - date.getTime();
        System.out.println(nano);
    }
}
