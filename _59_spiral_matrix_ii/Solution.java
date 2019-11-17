package _59_spiral_matrix_ii;

import java.util.Arrays;

// https://leetcode.com/problems/spiral-matrix-ii/

// 思路:
// 定义上下左右界限
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        int i = 1;
        while (i <= n * n) {
            for (int j = left; j <= right && i <= n * n; ++j) {
                ret[up][j] = i++;
            }
            for (int j = up + 1; j <= down && i <= n * n; ++j) {
                ret[j][right] = i++;
            }
            for (int j = right - 1; j >= left && i <= n * n; --j) {
                ret[down][j] = i++;
            }
            for (int j = down - 1; j >= up + 1 && i <= n * n; --j) {
                ret[j][left] = i++;
            }
            up++;
            down--;
            left++;
            right--;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().generateMatrix(3)));
    }
}