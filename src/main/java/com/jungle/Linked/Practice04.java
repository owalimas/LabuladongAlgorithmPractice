package com.jungle.Linked;

/**
 * @Description   876. 链表的中间结点 https://leetcode.cn/problems/middle-of-the-linked-list/
 * @Author Jungle
 * @DATE 2022/5/11
 **/
public class Practice04 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head ,fast = head;
        //同时需要控制两个，奇数个，和偶数个，循环最后触发不通的限制
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
