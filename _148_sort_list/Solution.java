package _148_sort_list;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-20 15:48:14
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-20 17:34:58
 *
 * @FilePath: /leetcode/_148_sort_list/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

// https://leetcode.com/problems/sort-list/

// 思路:
// 链表归并

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step 3. merge l1 and l2
        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;

        if (l2 != null)
            p.next = l2;

        return l.next;
    }

}

// class Solution {
// public ListNode sortList(ListNode head) {
// if (head == null || head.next == null) {
// return head;
// }
// ListNode slow = head;
// ListNode fast = head;

// // 此代码会报错, 需要把下面改成while (fast.next != null && fast.next.next != null)
// // 因为无法处理长度为2的情况
// while (fast != null && fast.next != null) {
// slow = slow.next;
// fast = fast.next.next;
// }
// ListNode right = slow.next;
// slow.next = null;
// ListNode left = sortList(head);
// right = sortList(right);
// ListNode dummy = new ListNode(Integer.MIN_VALUE);
// ListNode ret = dummy;
// while (left != null && right != null) {
// if (left.val <= right.val) {
// dummy.next = left;
// left = left.next;
// } else {
// dummy.next = right;
// right = right.next;
// }
// dummy = dummy.next;
// }
// if (left != null) {
// dummy.next = left;
// }
// if (right != null) {
// dummy.next = right;
// }
// return ret.next;
// }
// }