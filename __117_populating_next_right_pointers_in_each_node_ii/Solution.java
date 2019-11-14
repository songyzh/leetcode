package __117_populating_next_right_pointers_in_each_node_ii;
/*
 * @Author: your name
 *
 * @Date: 2019-11-12 22:10:15
 *
 * @LastEditTime: 2019-11-13 18:29:53
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath:
 * /leetcode/_117_populating_next_right_pointers_in_each_node_ii/Solution.java
 */

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

// 思路:
// 处理到每一层时, 其上一层已经处理好了
// 递归处理
// 注意递归时先处理右边
// 方法2: bfs逐层处理

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
        if (root == null) {
            return root;
        }
        // 上层已经处理完毕了, 需要处理本层
        // 本节点的左右, 以及本节点next的子节点
        if (root.left != null) {
            root.left.next = root.right != null ? root.right : findNext(root.next);
        }
        if (root.right != null) {
            root.right.next = findNext(root.next);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    Node findNext(Node root) {
        // 找到此节点的下部最左节点
        if (root == null) {
            return root;
        }
        if (root.left != null) {
            return root.left;
        }
        if (root.right != null) {
            return root.right;
        }
        return findNext(root.next);
    }
}