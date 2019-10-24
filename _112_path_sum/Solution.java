package _112_path_sum;
/*
 * @Author: your name
 * @Date: 2019-10-24 09:04:44
 * @LastEditTime: 2019-10-24 09:09:28
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_112_path_sum/Solution.java
 */

// https://leetcode.com/problems/path-sum/

// 思路:
// 把问题划分为子问题: 从sum中减去root.val, 则root.left或root.right是否有一个, 满足和等于sum - root.val

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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(left, sum - root.val) || hasPathSum(right, sum - root.val);
    }
}