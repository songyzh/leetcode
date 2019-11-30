package _200_number_of_islands;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-21 19:04:32
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-21 19:15:20
 *
 * @FilePath: /leetcode/_200_number_of_islands/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

// https://leetcode.com/problems/number-of-islands/

// 思路:
// 找到1, 结果即可加一, 并把所有相连的1都标记起来

class Solution {
    public int numIslands(char[][] grid) {
        int ret = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                char c = grid[i][j];
                if (c == '1') {
                    ret++;
                    helper(grid, i, j);
                }
            }
        }
        return ret;
    }

    void helper(char[][] grid, int i, int j) {
        // 标记
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = 0;
            helper(grid, i - 1, j);
            helper(grid, i + 1, j);
            helper(grid, i, j + 1);
            helper(grid, i, j - 1);
        }

    }
}