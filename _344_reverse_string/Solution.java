package _344_reverse_string;
/*
 * @Author: your name
 *
 * @Date: 2019-11-07 18:03:18
 *
 * @LastEditTime: 2019-11-07 18:05:34
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_344_reverse_string/Solution.java
 */

// https://leetcode.com/problems/reverse-string/

// 思路:
// 原地翻转数组
// 使用双指针

class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}