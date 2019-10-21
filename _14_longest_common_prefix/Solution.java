package _14_longest_common_prefix;
/*
 * @Author: your name
 * @Date: 2019-10-20 22:06:02
 * @LastEditTime: 2019-10-20 22:11:02
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_14_longest_common_prefix/Solution.java
 */

// https://leetcode.com/problems/longest-common-prefix/

// 思路:
// 以数组中第一个string为基础, 逐步增加字符串长度
// 检查是否是公共前缀

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String ret = "";
        String shortest = strs[0];
        for (String s : strs) {
            if (s.length() < shortest.length()) {
                shortest = s;
            }
        }
        outer: for (int i = 1; i <= shortest.length(); ++i) {
            String sub = shortest.substring(0, i);
            for (String s : strs) {
                if (!s.startsWith(sub)) {
                    continue outer;
                }
            }
            ret = sub;
        }
        return ret;
    }
}