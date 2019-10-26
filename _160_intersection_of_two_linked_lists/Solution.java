package _160_intersection_of_two_linked_lists;
/*
 * @Author: your name
 *
 * @Date: 2019-10-26 17:09:50
 *
 * @LastEditTime: 2019-10-26 17:22:12
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_160_intersection_of_two_linked_lists/Solution.java
 */

// https://leetcode.com/problems/intersection-of-two-linked-lists/

// 思路:
// 先找到两个链表的长度, 长的链表提前next, 然后同步next直到相交

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode headACopy = headA;
        ListNode headBCopy = headB;
        int lenA = 0;
        int lenB = 0;
        while (headACopy != null) {
            lenA++;
            headACopy = headACopy.next;
        }
        while (headBCopy != null) {
            lenB++;
            headBCopy = headBCopy.next;
        }
        int delta = lenA - lenB;
        if (delta > 0) {
            for (int i = 0; i < delta; ++i) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < -delta; ++i) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        if (headA == headB) {
            return headA;
        }
        return null;
    }
}