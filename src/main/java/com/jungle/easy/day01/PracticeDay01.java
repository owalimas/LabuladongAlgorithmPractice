package com.jungle.easy.day01;

import java.util.PriorityQueue;

/**
 * @Description Day01. 单链表解题技巧
 * 1. 双指针技巧秒杀七道链表题目 第一个练习 合并两个有序链表
 * 2. 合并 k 个有序链表
 * 3.单链表的倒数第-k-个节点
 * 4.876. 链表的中间结点
 * 5.
 * @Author Jungle
 * @DATE 2022/5/11
 **/
public class PracticeDay01 {

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


        //前置知识：二叉堆详解实现优先级队列
        //1. 二叉树的数组表示
        // 2. 最大堆的维护：1）Swin上浮 2）sink下沉
        // 3. 优先级队列的插入与删除 1)insertMq 从尾部插入，然后一路往上浮到合适的位置。 2）deleteMq 将头和尾一换，删除尾部，然后一路下沉
        //合并链表
        public ListNode mergeKLists(ListNode[] lists) {
            //首先为了选取多个链表中的最小节点，那么肯定是类似于双指针，需要多个指针
            // 可以理解为：此处选用优先级队列作为存储这么多指针的数据结构
            // 实际上就是循环遍历K个链表,第N个位置上谁最小，我放水进入结构链表
            ListNode res = new ListNode(-1), p = res;
            PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
            //插入K个链表的第1个位置（头节点）
            for (ListNode head : lists) {
                if (head != null) {
                    pq.add(head);
                }
            }
            while (!pq.isEmpty()) {
                ListNode node = pq.poll();
                p.next = node;
                if (node.next != null) {
                    pq.add(node.next);
                }
                //结果链表的指针循环
                p = p.next;
            }
            return res.next;
        }

        //首先考虑正向遍历，两次遍历和简单，先计算长度N，在遍历找到N-K+1就是的
        //其次，为了一次遍历得到，可以直接用快慢指针实现,p1节点先走K步
        //然后p2从头开始和p1一起走，最后p1走到结尾，p2自然指到了倒数第n个节点
        //单链表的倒数第-k-个节点
        public int kthToLast(ListNode head, int k) {
            ListNode p1 = head, p2 = head;
            int count = 1;
            //1,2,3,4,5
            while (count <= k) {
                p1 = p1.next;
                count++;
            }
            while (p1 != null) {
                p2 = p2.next;
                p1 = p1.next;
            }
            return p2.val;
        }

        public ListNode middleNode(ListNode head) {
            ListNode slow = head, fast = head;
            //同时需要控制两个，奇数个，和偶数个，循环最后触发不通的限制
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

    }


}
