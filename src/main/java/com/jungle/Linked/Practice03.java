package com.jungle.Linked;

/**
 * @Description https://labuladong.github.io/algo/2/17/16/#单链表的倒数第-k-个节点
 * @Author Jungle
 * @DATE 2022/5/11
 **/
public class Practice03 {
    //首先考虑正向遍历，两次遍历和简单，先计算长度N，在遍历找到N-K+1就是的
    //其次，为了一次遍历得到，可以直接用快慢指针实现,p1节点先走K步
    //然后p2从头开始和p1一起走，最后p1走到结尾，p2自然指到了倒数第n个节点

    class Solution {
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

    }
}
