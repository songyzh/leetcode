package _62_unique_paths;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-17 11:33:03
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-17 11:48:36
 *
 * @FilePath: /leetcode/_62_unique_paths/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

// https://leetcode.com/problems/unique-paths/

// 思路:
// dp, 到达某个格子的方法, 等于到达其上的方法数+到达其左的方法数

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] ret = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ret[i][j] = i * j == 0 ? 1 : ret[i - 1][j] + ret[i][j - 1];
            }
        }
        return ret[m - 1][n - 1];
    }
}