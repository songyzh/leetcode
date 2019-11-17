package _48_rotate_image;
/*
 * @Author: your name
 * @Date: 2019-11-15 20:12:47
 * @LastEditTime: 2019-11-15 22:08:11
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_48_rotate_image/Solution.java
 */

// https://leetcode.com/problems/rotate-image/

// 思路:
// 画图即可
// 先沿向右下的对角线翻转, 然后左右翻转

class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < n; ++i) {
            int[] row = matrix[i];
            int j = 0;
            int k = n - 1;
            while (j < k) {
                int tmp = row[j];
                row[j] = row[k];
                row[k] = tmp;
                j++;
                k--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        new Solution().rotate(a);
    }
}