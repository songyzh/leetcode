package _63_unique_paths_ii;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-17 11:51:08
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-17 12:06:09
 *
 * @FilePath: /leetcode/_63_unique_paths_ii/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

// https://leetcode.com/problems/unique-paths-ii/

// 思路:
// 类似上一题, dp求解. 到达障碍物的方法为0

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    if (i == 0 && j > 0 && obstacleGrid[i][j - 1] == 0
                            || j == 0 && i > 0 && obstacleGrid[i - 1][j] == 0) {
                        obstacleGrid[i][j] = 0;
                    } else {
                        obstacleGrid[i][j] = i * j == 0 ? 1 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];

                    }
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }
}