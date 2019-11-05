package _205_isomorphic_strings;
/*
 * @Author: your name
 * @Date: 2019-11-02 12:10:13
 * @LastEditTime: 2019-11-03 09:41:39
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_205_isomorphic_strings/Solution.java
 */

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/isomorphic-strings/

// 思路:
// 对s和t, 分别找到其模式: 从左到右, 把映射关系存在map中
// 最后比较模式是否一致

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sMap.get(sChar) == null && tMap.get(tChar) == null) {
                sMap.put(sChar, i);
                tMap.put(tChar, i);
            } else if (sMap.get(sChar) == null || tMap.get(tChar) == null || sMap.get(sChar) != tMap.get(tChar)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("paper", "title"));
    }
}