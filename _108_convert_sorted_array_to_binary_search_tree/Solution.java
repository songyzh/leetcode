package _108_convert_sorted_array_to_binary_search_tree;
/*
 * @Author: your name
 * @Date: 2019-10-23 21:30:11
 * @LastEditTime: 2019-10-23 21:38:33
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_108_convert_sorted_array_to_binary_search_tree/Solution.java
 */

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

// 思路:
// 以中间的元素为二叉树的根节点, 左子树以数组左部分构建, 右子树以数组右部分构建

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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int pivot = (left + right) / 2;
        TreeNode ret = new TreeNode(nums[pivot]);
        ret.left = helper(nums, left, pivot - 1);
        ret.right = helper(nums, pivot + 1, right);
        return ret;
    }
}