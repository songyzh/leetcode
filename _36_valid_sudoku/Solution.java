package _36_valid_sudoku;
/*
 * @Author: your name
 *
 * @Date: 2019-11-15 15:16:04
 *
 * @LastEditTime: 2019-11-15 15:33:09
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_36_valid_sudoku/Solution.java
 */

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/valid-sudoku/

// 思路:
// 逐行逐列逐块验证

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 行
        for (int i = 0; i < 9; ++i) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; ++j) {
                char c = board[i][j];
                if (!('0' <= c && c <= '9' || '.' == c)) {
                    return false;
                }
                if ('.' != c && set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
        }
        // 列
        for (int i = 0; i < 9; ++i) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; ++j) {
                char c = board[j][i];
                if (!('0' <= c && c <= '9' || '.' == c)) {
                    return false;
                }
                if ('.' != c && set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
        }
        // 块
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Character> set = new HashSet<>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        char c = board[i + k][j + l];
                        if (!('0' <= c && c <= '9' || '.' == c)) {
                            return false;
                        }
                        if ('.' != c && set.contains(c)) {
                            return false;
                        }
                        set.add(c);
                    }
                }
            }
        }
        return true;
    }
}