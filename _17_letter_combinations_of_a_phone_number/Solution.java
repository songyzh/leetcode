package _17_letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author: your name
 *
 * @Date: 2019-11-14 17:02:52
 *
 * @LastEditTime: 2019-11-14 17:26:30
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_17_letter_combinations_of_a_phone_number/Solution.java
 */
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

// 思路:
// 回溯法
// 2. dp

class Solution {
    String digits;
    Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return new ArrayList<>();
        }
        this.digits = digits;
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return dp(digits.length() - 1);
    }

    List<String> dp(int endIndex) {
        if (endIndex == -1) {
            return Arrays.asList("");
        }
        List<String> ret = new ArrayList<>();
        List<String> prev = dp(endIndex - 1);
        for (String p : prev) {
            for (char c : map.get(digits.charAt(endIndex)).toCharArray()) {
                ret.add(p + String.valueOf(c));
            }
        }
        return ret;
    }
}
