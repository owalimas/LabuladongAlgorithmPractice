package com.jungle.day02;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description Day02. 数组双指针解题技巧
 * 1.剑指 Offer II 022. 链表中环的入口节点
 * 2.83. 删除排序链表中的重复元素
 * 3.26. 删除有序数组中的重复项
 * 4.27. 移除元素
 * 5.283. 移动零
 * 6.167. 两数之和 II - 输入有序数组
 * 7.5. 最长回文子串
 * 8.76. 最小覆盖子串(滑动窗口，左右指针)
 * @Author Jungle
 * @DATE 2022/5/14
 **/
public class PracticeDay02 {

    private static Scanner scanner = new Scanner(System.in);

    //剑指 Offer II 022. 链表中环的入口节点
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        //第一次相遇 慢指针走过的步长 K
        int step = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            step++;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) {
            // fast 遇到空指针说明没有环
            return null;
        }
        fast = head;
        //将快指针重置，然后和慢指针同速前进，慢指针从第一次相遇点，开始往前走
        //第二次相遇，两指针走过的步长，而最终入口就是, 就是这个步长 K-M,M就是入口距离第一次相遇的距离
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    //83. 删除排序链表中的重复元素
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        //同样的，这里fas
        ListNode fast = head.next, slow = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        //关键步骤，走完之后，slow可能后面全是和当前值相等的节点，这些节点没办法再替换，直接去掉就行
        slow.next = null;
        return head;
    }

    //26. 删除有序数组中的重复项
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //此处fast为0 为 1 都可以，因为为0的话下面循环多走一次（不会进入if）
        int slow = 0, fast = 1, n = nums.length;
        while (fast < n) {
            //fast比slow先走，如果遇到不一样的就把slow位置的替换掉
            //不需要管后面的数据
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    //27. 移除元素
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            //当快指针在前面遇到不等于目标值时，就替换slow上的数据
            //这样前面都是不等于目标值的数据
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    //283. 移动零
    public void moveZeroes(int[] nums) {
        //注意这里有个点，fast必须和slow同点前进
        //因为当不存在0时，就可以两个指针一直指向一个值向前推进，不改变数组非0元素位置
        //这一类快慢指针，可以不管fast的位置，无脑从0开始，有问题在调整
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
    }

    //167. 两数之和 II - 输入有序数组
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        //本质上就是二分查找，可以理解为左右指针，并且要注意左右边界的修改
        while (left <= right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    //5. 最长回文子串
    //分为两种情况，奇数、偶数
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            //以s[i]为 中心的最长字串
            String res1 = palindrome(s, i, i);
            //以s[i]、s[i+1]为中心的最长字串
            String res2 = palindrome(s, i, i + 1);
            res = res.length() > res1.length() ? res : res1;
            res = res.length() > res2.length() ? res : res2;
        }
        return res;

    }

    //5. 最长回文子串 子函数，确定最长回文串
    private String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        //这里注意边界，l+1,r 左闭右开，
        //直接考虑最后 l = 0  和 r = s.length() -1 进入循环，出来后的情况
        return s.substring(l + 1, r);
    }

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
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }

    @Test
    public void testMinWindow() {
        String s = "EBBANCF";
        String t = "ABC";
        String res = this.minWindow(s, t);
        System.out.println(res);
    }
}
