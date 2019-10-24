package _58_length_of_last_word;
/*
 * @Author: your name
 *
 * @Date: 2019-10-22 12:16:31
 *
 * @LastEditTime: 2019-10-22 18:54:06
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_58_length_of_last_word/Solution.java
 */

// https://leetcode.com/problems/length-of-last-word/

// 思路:
// 先trim, 去除最后的空白字符
// 然后从后向前, 每个非空格, 代表1的长度

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int ret = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == ' ') {
                return ret;
            }
            ret++;
        }
        return ret;
    }
}