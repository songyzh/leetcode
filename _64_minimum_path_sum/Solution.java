package _64_minimum_path_sum;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-17 12:07:42
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-17 12:15:09
 *
 * @FilePath: /leetcode/_64_minimum_path_sum/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

// https://leetcode.com/problems/minimum-path-sum/

// 思路:
// dp

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}