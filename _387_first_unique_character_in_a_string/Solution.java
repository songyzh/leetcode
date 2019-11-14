package _387_first_unique_character_in_a_string;
/*
 * @Author: your name
 *
 * @Date: 2019-11-08 16:47:56
 *
 * @LastEditTime: 2019-11-08 16:52:56
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_387_first_unique_character_in_a_string/Solution.java
 */

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/first-unique-character-in-a-string/

// 思路:
// 先使用map记录每个字符出现的次数, 然后在遍历一次即可
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> lookup = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (lookup.containsKey(c)) {
                lookup.put(c, lookup.get(c) + 1);
            } else {
                lookup.put(c, 1);
            }
        }
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (lookup.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}