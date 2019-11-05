package _203_remove_linked_list_elements;
/*
 * @Author: your name
 *
 * @Date: 2019-11-02 11:17:26
 *
 * @LastEditTime: 2019-11-02 11:22:18
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_203_remove_linked_list_elements/Solution.java
 */

// https://leetcode.com/problems/remove-linked-list-elements/

// 思路:
// 链表的第一个元素也可能需要删除, 因此创建一个dummy节点

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

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode ret = dummy;

        while (dummy.next != null) {
            if (dummy.next.val == val) {
                dummy.next = dummy.next.next;
            } else {
                dummy = dummy.next;
            }
        }
        return ret.next;
    }
}