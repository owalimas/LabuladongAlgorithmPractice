package com.jungle.exam.other;

import java.util.Date;
import java.util.Scanner;

/** 同学阿里蚂蚁金服笔试题
 * 題目：b == 2a c = 4a 輸入數字，求最少个数的字母组成
 */
public class ALMYWritten {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Date date = new Date();
        int n = scanner.nextInt();
        StringBuilder res = new StringBuilder();
        int[]  memo = new int[26];
        for (int i = 0; i < 26; i++) {
            memo[i] = (int) Math.pow(2,i);
        }
        while(n > 0){
            for (int i = 0; i < 25; i++) {
                if(n >= memo[i] && n < memo[i+1]){
                    n = n - memo[i];
                    res.append((char)('a'+i));
                    break;
                }
            }
        }
        Date date2 = new Date();
        long nano = date2.getTime() - date.getTime();
        System.out.println(nano);
        System.out.println(res);
    }

}
