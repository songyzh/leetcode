package _290_word_pattern;
/*
 * @Author: your name
 *
 * @Date: 2019-11-05 13:44:54
 *
 * @LastEditTime: 2019-11-05 13:57:43
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_290_word_pattern/Solution.java
 */

import java.util.HashMap;

// https://leetcode.com/problems/word-pattern/

import java.util.Map;

// 思路:
// 分别找到二者的模式, 比较即可

class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] ca = pattern.toCharArray();
        int[] pattern1 = new int[ca.length];
        Map<Character, Integer> lookup1 = new HashMap<>();
        for (int i = 0; i < ca.length; ++i) {
            char c = ca[i];
            if (lookup1.containsKey(c)) {
                pattern1[i] = lookup1.get(c);
            } else {
                lookup1.put(c, i);
                pattern1[i] = i;
            }
        }

        String[] sa = str.split(" ");
        int[] pattern2 = new int[sa.length];
        Map<String, Integer> lookup2 = new HashMap<>();
        for (int i = 0; i < sa.length; ++i) {
            String s = sa[i];
            if (lookup2.containsKey(s)) {
                pattern2[i] = lookup2.get(s);
            } else {
                lookup2.put(s, i);
                pattern2[i] = i;
            }
        }
        if (ca.length != sa.length) {
            return false;
        }
        for (int i = 0; i < pattern1.length; ++i) {
            if (pattern1[i] != pattern2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordPattern("abaa", "dog cat cat dog"));
    }
}