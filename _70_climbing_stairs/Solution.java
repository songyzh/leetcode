package _70_climbing_stairs;
/*
 * @Author: your name
 * @Date: 2019-10-23 18:22:11
 * @LastEditTime: 2019-10-23 18:26:48
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_70_climbing_stairs/Solution.java
 */

// https://leetcode.com/problems/climbing-stairs/

// 思路:
// 爬到第n阶前, 必然在第n-2阶或第n-1阶
// 递归的方法会超时, 可以空间换时间, 用dp解决

class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}