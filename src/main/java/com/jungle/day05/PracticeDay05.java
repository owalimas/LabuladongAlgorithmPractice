package com.jungle.day05;

import org.junit.Test;

import java.util.*;

/**
 * @Description Day05. 滑动窗口技巧
 * 1.76. 最小覆盖子串(滑动窗口，左右指针)
 * 2.567. 字符串的排列
 * 3.438. 找到字符串中所有字母异位词
 * @Author Jungle
 * @DATE 2022/5/16
 **/
public class PracticeDay05 {
    //76. 最小覆盖子串
    // 作为滑动窗口的模板题，进行训练
    public String minWindow(String s, String t) {
        //分别记录需要寻找的字串匹配情况，以及原字串上的滑动窗口匹配情况
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        //按照左闭右开的规则去进行
        int left = 0, right = 0;
        //其中 valid 变量表示窗口中满足 need 条件的字符个数，如果 valid 和 need.size() 的大小相同，则说明窗口已满足条件
        int valid = 0;
        // 非模板：start最小覆盖字串的起始索引，len: 最小覆盖字串的大小，最后还是最大值表明未匹配上
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            //移入窗口的元素
            char c = s.charAt(right);
            //扩大窗口
            right++;
            //一系列操作
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                //同一个字母的话，valid也只会加一次
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            //判断左侧窗口是否需要收缩,当前窗口内满足need所需的条件，就是所有字母都至少有一个
            while (valid == need.size()) {
                //缩小窗口前的一系列操作
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                //一处窗口的元素
                char d = s.charAt(left);
                //窗口缩小
                left++;
                //进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }

        }
        //返回最终结果，如果和初始值相同，那么就是没找到,找到
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    @Test
    public void testMinWindow() {
        String s = "EBBANCF";
        String t = "ABC";
        String res = this.minWindow(s, t);
        System.out.println(res);
    }

    //567. 字符串的排列
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s2.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s1.length()) {
            //移入窗口的字符
            char c = s1.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            //窗口内数据的一系列更新操作
            //输出窗口位置调试
            System.out.println("increase window: " + left + " " + right);
            //窗口需要缩小，此题中就是window中的长度超过了所需的长度
            //注意边界问题，首先[left,right)此处等于s2的长度时，其次由于从0开始，就是已经超过实际需要的长度了
            while (right - left >= s2.length()) {
                if (valid == need.size()) {
                    return true;
                }
                //移出窗口的字符
                char d = s1.charAt(left);
                //窗口锁小
                left++;
                System.out.println("decrease window: " + left + " " + right);
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return false;
    }

    @Test
    public void testCheckInclusion() {
        String s = "eidbaooo";
        String t = "ab";
        System.out.println(s + "\n" + t);

        boolean b = this.checkInclusion(s, t);
        System.out.println(b);
    }

    //438. 找到字符串中所有字母异位词
    public List<Integer> findAnagrams(String s, String p) {
        //结果链表
        List<Integer> res = new LinkedList<>();
        //模板题目，输出的是左指针left
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        //扩充右边界条件
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            System.out.println("increase window: " + left + " " + right);
            //缩小左边界条件
            while (right - left >= p.length()) {
                //已经包含异位词
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                System.out.println("decrease window: " + left + " " + right);
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return res;
    }


    @Test
    public void testFindAnagrams() {
        String s = "cbaebabacd";
        String t = "abc";
        System.out.println(s + "\n" + t);

        List<Integer> anagrams = this.findAnagrams(s, t);
        System.out.println(Arrays.toString(anagrams.toArray()));
    }
}
