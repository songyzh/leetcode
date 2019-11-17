package _49_group_anagrams;
/*
 * @Author: your name
 *
 * @Date: 2019-11-15 19:25:17
 *
 * @LastEditTime: 2019-11-15 19:33:56
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_49_group_anagrams/Solution.java
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/group-anagrams/

// 思路:
// 使用map存储

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String converted = new String(ca);
            if (map.containsKey(converted)) {
                map.get(converted).add(str);
            } else {
                List<String> lst = new ArrayList<>();
                lst.add(str);
                map.put(converted, lst);
            }
        }
        return new ArrayList<>(map.values());
    }
}