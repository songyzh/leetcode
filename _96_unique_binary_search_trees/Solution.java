package _96_unique_binary_search_trees;
/*
 * @Author: your name
 * @Date: 2019-11-11 17:28:11
 * @LastEditTime: 2019-11-11 17:34:38
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_96_unique_binary_search_trees/Solution.java
 */

// https://leetcode.com/problems/unique-binary-search-trees/

// 思路:
// 递归求解

class Solution {
    public int numTrees(int n) {
        return helper(1, n);
    }

    int helper(int start, int end) {
        int ret = 0;
        if (start >= end) {
            return 1;
        }
        for (int i = start; i <= end; ++i) {
            ret += helper(start, i - 1) * helper(i + 1, end);
        }
        return ret;
    }
}