package _235_lowest_common_ancestor_of_a_binary_search_tree;
/*
 * @Author: your name
 *
 * @Date: 2019-11-04 12:00:06
 *
 * @LastEditTime: 2019-11-04 12:09:54
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath:
 * /leetcode/_235_lowest_common_ancestor_of_a_binary_search_tree/Solution.java
 */

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

// 思路:
// 由于是二叉搜索树, 没有相等的节点
// 如果两个节点的大小位于根节点两侧, 则最低公共祖先即为根节点
// 如果位于同一侧, 则问题转化为以根节点的相应子节点为根节点, 继续搜寻

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        int rootVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        if (pVal < rootVal && rootVal < qVal || qVal < rootVal && rootVal < pVal) {
            return root;
        }
        if (pVal < rootVal && qVal < rootVal) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (pVal > rootVal && qVal > rootVal) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}