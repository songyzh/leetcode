package _392_is_subsequence;
/*
 * @Author: your name
 *
 * @Date: 2019-11-08 17:03:16
 *
 * @LastEditTime: 2019-11-08 17:17:48
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_392_is_subsequence/Solution.java
 */

// https://leetcode.com/problems/is-subsequence/

// 思路:
// 从左向右搜寻

class Solution {
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        for (char c : s.toCharArray()) {
            while (j < t.length() && t.charAt(j) != c) {
                j++;
            }
            if (j == t.length()) {
                return false;
            }
            if (t.charAt(j) == c) {
                j++;
            }
        }
        return true;
    }
}