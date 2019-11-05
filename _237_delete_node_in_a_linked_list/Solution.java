/*
 * @Author: your name
 * @Date: 2019-11-04 13:44:02
 * @LastEditTime: 2019-11-04 13:59:25
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_237_delete_node_in_a_linked_list/Solution.java
 */
package _237_delete_node_in_a_linked_list;

// https://leetcode.com/problems/delete-node-in-a-linked-list/

// 思路:
// 修改节点的值

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
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}