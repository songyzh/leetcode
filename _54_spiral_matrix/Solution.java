package _54_spiral_matrix;
/*
 * @Author: your name
 *
 * @Date: 2019-11-16 15:00:28
 *
 * @LastEditTime: 2019-11-16 15:09:53
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_54_spiral_matrix/Solution.java
 */

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/

// 思路:
// 定义边界, 一圈一圈处理

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return ret;
        }
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int total = matrix.length * matrix[0].length;
        while (ret.size() < total) {
            for (int i = left; i <= right && ret.size() < total; ++i) {
                ret.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down && ret.size() < total; ++i) {
                ret.add(matrix[i][right]);
            }
            for (int i = right - 1; i >= left && ret.size() < total; --i) {
                ret.add(matrix[down][i]);
            }
            for (int i = down - 1; i >= up + 1 && ret.size() < total; --i) {
                ret.add(matrix[i][left]);
            }
            up++;
            down--;
            left++;
            right--;
        }
        return ret;
    }
}