package _105_construct_binary_tree_from_preorder_and_inorder_traversal;
/*
 * @Author: your name
 * @Date: 2019-11-12 12:46:25
 * @LastEditTime: 2019-11-12 14:59:23
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_105_construct_binary_tree_from_preorder_and_inorder_traversal/Solution.java
 */

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

// 思路:
// 递归求解

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
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        this.preorder = preorder;
        this.inorder = inorder;
        return helper(0, preorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode helper(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = map.get(rootVal);

        int inOrderLeftStart = inStart;
        int inOrderLeftEnd = inIndex - 1;
        int inOrderRightStart = inIndex + 1;
        int inOrderRightEnd = inEnd;

        int preOrderLeftStart = preStart + 1;
        int preOrderLeftEnd = preStart + (inIndex - inStart);
        int preOrderRightStart = preOrderLeftEnd + 1;
        int preOrderRightEnd = preEnd;

        root.left = helper(preOrderLeftStart, preOrderLeftEnd, inOrderLeftStart, inOrderLeftEnd);
        root.right = helper(preOrderRightStart, preOrderRightEnd, inOrderRightStart, inOrderRightEnd);
        return root;
    }
}