package _242_valid_anagram;
/*
 * @Author: your name
 *
 * @Date: 2019-11-04 14:03:59
 *
 * @LastEditTime: 2019-11-04 14:07:12
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_242_valid_anagram/Solution.java
 */

import java.util.Arrays;

// https://leetcode.com/problems/valid-anagram/

// 思路:
// 排序后, 应为相同的数组

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);
        for (int i = 0; i < sa.length; ++i) {
            if (sa[i] != ta[i]) {
                return false;
            }
        }
        return true;
    }
}