package __3_longest_substring_without_repeating_characters;
/*
 * @Author: your name
 *
 * @Date: 2019-11-14 13:22:42
 *
 * @LastEditTime: 2019-11-14 15:13:23
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath:
 * /leetcode/_3_longest_substring_without_repeating_characters/Solution.java
 */

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashMap;
import java.util.Map;

// 思路:
// 从左向右遍历数组, map记录每个字符最后出现的下标.
// 遍历过程中, 可得到以i为终点的字符串; left记录起点
// 注意最后一个字符

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ret = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, i);
            int curr = i - left + 1;
            ret = ret > curr ? ret : curr;
        }
        return ret;
    }
}