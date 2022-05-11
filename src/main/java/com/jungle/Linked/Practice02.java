package com.jungle.Linked;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @Description 合并 k 个有序链表
 * @Author Jungle
 * @DATE 2022/5/11
 **/
public class Practice02 {
    //前置知识：二叉堆详解实现优先级队列
    //1. 二叉树的数组表示
    // 2. 最大堆的维护：1）Swin上浮 2）sink下沉
    // 3. 优先级队列的插入与删除 1)insertMq 从尾部插入，然后一路往上浮到合适的位置。 2）deleteMq 将头和尾一换，删除尾部，然后一路下沉
    //合并链表
    class Solution {
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
            while(!pq.isEmpty()){
                ListNode node = pq.poll();
                p.next = node;
                if(node.next != null){
                    pq.add(node.next);
                }
                //结果链表的指针循环
                p = p.next;
            }
            return res.next;
        }

        @Test
        void testMergeKLists() {

        }
    }
}
