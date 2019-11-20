package _79_word_search;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-18 14:42:47
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-18 15:29:27
 *
 * @FilePath: /leetcode/_79_word_search/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

// https://leetcode.com/problems/word-search/

// 思路:
// 回溯求解, 记录用过的坐标
// 注意: 使用board本身记录信息

class Solution {
    String word;
    char[][] board;

    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.board = board;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (helper(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean helper(int i, int j, int index) {
        char current = board[i][j];
        if (current != word.charAt(index) || board[i][j] == '*') {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        board[i][j] = '*';
        if (i > 0 && helper(i - 1, j, index + 1) || i < board.length - 1 && helper(i + 1, j, index + 1)
                || j > 0 && helper(i, j - 1, index + 1) || j < board[0].length - 1 && helper(i, j + 1, index + 1)) {
            return true;
        }
        board[i][j] = current;
        return false;
    }
}