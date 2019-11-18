package _74_search_a_2_d_matrix;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-18 10:22:20
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-18 11:33:14
 *
 * @FilePath: /leetcode/_74_search_a_2_d_matrix/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

// https://leetcode.com/problems/search-a-2d-matrix/

// 思路:
// 先找行, 再找列
// 2. 二分查找的方式

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}