package _383_ransom_note;
/*
 * @Author: your name
 *
 * @Date: 2019-11-08 10:57:47
 *
 * @LastEditTime: 2019-11-08 16:38:36
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_383_ransom_note/Solution.java
 */

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/ransom-note/

// 思路:
// 把可用字母保存起来, 需要用到时, 减一. 减至零时, 删除key. 如果还剩字母即可

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> lookup = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            if (lookup.containsKey(c)) {
                lookup.put(c, lookup.get(c) + 1);
            } else {
                lookup.put(c, 1);
            }
        }
        for (char c : ransomNote.toCharArray()) {
            if (!lookup.containsKey(c)) {
                return false;
            }
            if (lookup.get(c) == 1) {
                lookup.remove(c);
            } else {
                lookup.put(c, lookup.get(c) - 1);
            }
        }
        return true;
    }
}