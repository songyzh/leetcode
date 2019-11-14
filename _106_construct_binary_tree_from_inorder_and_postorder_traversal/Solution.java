package _106_construct_binary_tree_from_inorder_and_postorder_traversal;
/*
 * @Author: your name
 *
 * @Date: 2019-11-12 15:00:04
 *
 * @LastEditTime: 2019-11-12 17:14:57
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath:
 * /leetcode/_106_construct_binary_tree_from_inorder_and_postorder_traversal/
 * Solution.java
 */

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

// 思路:
// 递归处理

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

    int[] inorder;
    int[] postorder;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return helper(0, inorder.length - 1, 0, postorder.length - 1);
    }

    TreeNode helper(int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
        if (inorderStart > inorderEnd || postorderStart > postorderEnd) {
            return null;
        }
        int rootVal = postorder[postorderEnd];
        TreeNode ret = new TreeNode(rootVal);
        int inorderIndex = map.get(rootVal);

        int leftInorderStart = inorderStart;
        int leftInorderEnd = inorderIndex - 1;
        int leftPostorderStart = postorderStart;
        int leftPostorderEnd = leftPostorderStart + (inorderIndex - inorderStart) - 1;

        int rightInorderStart = inorderIndex + 1;
        int rightInorderEnd = inorderEnd;
        int rightPostorderStart = leftPostorderEnd + 1;
        int rightPostorderEnd = postorderEnd - 1;
        ret.left = helper(leftInorderStart, leftInorderEnd, leftPostorderStart, leftPostorderEnd);
        ret.right = helper(rightInorderStart, rightInorderEnd, rightPostorderStart, rightPostorderEnd);
        return ret;
    }
}