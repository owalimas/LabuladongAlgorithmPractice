package com.jungle.Linked;

import org.junit.Test;

import java.util.List;

/**
 * @Description 双指针技巧秒杀七道链表题目 第一个练习 合并两个有序链表
 * @Author Jungle
 * @DATE 2022/5/11
 **/
public class Practice01 {

    // Definition for singly-linked list.

    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            //定义返回的链表头
            ListNode res = new ListNode(-1);
            //双指针p1,p2解决各自链表遍历, p是为了返回链表的遍历
            ListNode p1 = list1, p2 = list2, p = res;
            while (p1 != null && p2 != null) {
                if (p1.val > p2.val) {
                    p.next = p2;
                    p2 = p2.next;
                } else {
                    p.next = p1;
                    p1 = p1.next;
                }
                p = p.next;
            }
            if (p1 != null) {
                p.next = p1;
            } else {
                p.next = p2;
            }
            return res.next;
        }

        @Test
        void testLinkedOne() {

        }
    }


}
