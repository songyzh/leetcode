package _22_generate_parentheses;
/*
 * @Author: your name
 *
 * @Date: 2019-11-14 21:47:31
 *
 * @LastEditTime: 2019-11-14 21:58:37
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_22_generate_parentheses/Solution.java
 */

import java.util.ArrayList;

// https://leetcode.com/problems/generate-parentheses/

import java.util.List;

// 思路:
// 回溯

class Solution {
    List<String> ret = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        helper(new StringBuilder(), n, n);
        return ret;
    }

    void helper(StringBuilder current, int open, int close) {
        if (open == 0 && close == 0) {
            ret.add(current.toString());
            return;
        }
        if (open > 0) {
            StringBuilder newCurrent = new StringBuilder(current);
            newCurrent.append("(");
            helper(newCurrent, open - 1, close);
        }
        if (open < close) {
            StringBuilder newCurrent = new StringBuilder(current);
            newCurrent.append(")");
            helper(newCurrent, open, close - 1);
        }
    }
}