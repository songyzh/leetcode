package _6_zig_zag_conversion;
/*
 * @Author: your name
 *
 * @Date: 2019-11-14 15:33:10
 *
 * @LastEditTime: 2019-11-14 15:46:15
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_6_zig_zag_conversion/Solution.java
 */

// https://leetcode.com/problems/zigzag-conversion/

// 思路:
// 使用n个stringbuiler存储

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; ++i) {
            sbs[i] = new StringBuilder();
        }
        int line = 0;
        boolean down = true;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            sbs[line].append(c);
            if (line == numRows - 1) {
                down = false;
            } else if (line == 0) {
                down = true;
            }
            line += down ? 1 : -1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder sb : sbs) {
            ret.append(sb);
        }
        return ret.toString();
    }
}