package __166_fraction_to_recurring_decimal;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-21 12:05:17
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-21 14:42:35
 *
 * @FilePath: /leetcode/_166_fraction_to_recurring_decimal/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

import java.util.HashMap;

// https://leetcode.com/problems/fraction-to-recurring-decimal/

// 思路:
// 考虑边界条件, 正负号, 越界,

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }

        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            } else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
}