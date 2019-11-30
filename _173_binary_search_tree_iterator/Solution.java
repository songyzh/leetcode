package _173_binary_search_tree_iterator;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-21 14:46:23
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-21 15:22:43
 *
 * @FilePath: /leetcode/_173_binary_search_tree_iterator/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

import java.util.Stack;

// https://leetcode.com/problems/binary-search-tree-iterator/

// 思路:
// 二叉搜索树的性质

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

class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        helper(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        helper(node.right);
        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    void helper(TreeNode node) {
        while (node != null) {
            stack.add(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */