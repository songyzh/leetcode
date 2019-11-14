package _94_binary_tree_inorder_traversal;
/*
 * @Author: your name
 *
 * @Date: 2019-11-11 16:20:15
 *
 * @LastEditTime: 2019-11-11 16:36:19
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_94_binary_tree_inorder_traversal/Solution.java
 */

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-inorder-traversal/

// 思路:
// 中序遍历, 递归即可

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        if (root.left != null) {
            ret.addAll(inorderTraversal(root.left));
        }
        ret.add(root.val);
        if (root.right != null) {
            ret.addAll(inorderTraversal(root.right));
        }
        return ret;
    }
}