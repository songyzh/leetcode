package _73_set_matrix_zeroes;
/*
 * @Description:
 * @Author: syzh
 * @Date: 2019-11-17 14:04:55
 * @LastEditors: syzh
 * @LastEditTime: 2019-11-17 21:12:50
 * @FilePath: /leetcode/_73_set_matrix_zeroes/Solution.java
 * @Github: https://github.com/songyzh
 */

import java.util.Arrays;

// https://leetcode.com/problems/set-matrix-zeroes/

// 思路:
// 先找到为0的点的行和列, 保存起来
// 遍历matrix, 如果处于为0的行或列, 设为0
// 2. 把0的信息记录在第一行和第一列中

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i == 0) {
                        firstRow = true;
                    }
                    if (j == 0) {
                        firstCol = true;
                    }
                }
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRow) {
            Arrays.fill(matrix[0], 0);
        }
        if (firstCol) {
            for (int i = 0; i < m; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
}