package _28_implement_strStr;
/*
 * @Author: your name
 * @Date: 2019-10-21 08:14:40
 * @LastEditTime: 2019-10-21 08:19:56
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_28_implement_strStr/Solution.java
 */

// https://leetcode.com/problems/implement-strstr/

// 思路:
// 遍历haystack,
// 如果当前位置的字串 == needle, 返回当前index

class Solution {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int len = needle.length();
        for (int i = 0; i < haystack.length(); ++i) {
            int end = i + len;
            if (end > haystack.length()) {
                continue;
            }
            if (needle.equals(haystack.substring(i, end))) {
                return i;
            }
        }
        return -1;
    }
}