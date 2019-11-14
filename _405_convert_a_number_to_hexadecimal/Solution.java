package _405_convert_a_number_to_hexadecimal;
/*
 * @Author: your name
 *
 * @Date: 2019-11-11 08:52:44
 *
 * @LastEditTime: 2019-11-11 09:16:21
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_405_convert_a_number_to_hexadecimal/Solution.java
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/convert-a-number-to-hexadecimal/

// 思路:
// 将数字转为16进制, 可从右边开始, 每4个bit转为一个hex字符

class Solution {
    public String toHex(int num) {
        List<Character> hexes = new ArrayList<>();
        for (int j = 0; j < 8; ++j) {
            int current = 0;
            for (int i = 0; i < 4; ++i) {
                current += (num & 1) * Math.pow(2, i);
                num >>>= 1;
            }
            hexes.add(intToHex(current));
        }
        Collections.reverse(hexes);
        int firstNonZero = -1;
        for (int i = 0; i < hexes.size(); ++i) {
            if (hexes.get(i) != '0') {
                firstNonZero = i;
                break;
            }
        }
        if (firstNonZero == -1) {
            return "0";
        }
        hexes = hexes.subList(firstNonZero, hexes.size());
        StringBuilder sb = new StringBuilder();
        for (char c : hexes) {
            sb.append(c);
        }
        return sb.toString();
    }

    char intToHex(int num) {
        System.out.println("aaa" + num);
        if (num < 10) {
            return (char) (num + '0');
        }
        return (char) (num - 10 + 'a');
    }

    public static void main(String[] args) {
        System.out.println(new Solution().toHex(26));
    }
}