package _116_populating_next_right_pointers_in_each_node;
/*
 * @Author: your name
 *
 * @Date: 2019-11-12 21:34:10
 *
 * @LastEditTime: 2019-11-12 22:18:41
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath:
 * /leetcode/_116_populating_next_right_pointers_in_each_node/Solution.java
 */

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

// 思路:
// 处理到每一层时, 其上一层已经处理好了
// 递归处理

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    public Node connect(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}