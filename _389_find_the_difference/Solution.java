package _389_find_the_difference;
/*
 * @Author: your name
 *
 * @Date: 2019-11-08 16:53:54
 *
 * @LastEditTime: 2019-11-08 17:02:54
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_389_find_the_difference/Solution.java
 */

// https://leetcode.com/problems/find-the-difference/

// 思路:
// 使用数组记录出现的字符

class Solution {
    public char findTheDifference(String s, String t) {
        int[] lookup = new int[26];
        for (char c : t.toCharArray()) {
            lookup[c - 'a'] = lookup[c - 'a'] + 1;
        }
        for (char c : s.toCharArray()) {
            lookup[c - 'a'] = lookup[c - 'a'] - 1;
        }
        for (int i = 0; i < 26; ++i) {
            if (lookup[i] > 0) {
                return (char) (i + 'a');
            }
        }
        return 'a';
    }
}