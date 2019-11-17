package __43_multiply_strings;
/*
 * @Author: your name
 *
 * @Date: 2019-11-16 11:01:35
 *
 * @LastEditTime: 2019-11-16 11:44:29
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_43_multiply_strings/Solution.java
 */

import java.util.Arrays;

// https://leetcode.com/problems/multiply-strings/

// 思路:
// 所有位数分别相乘, 相加时, 使用自定义的string加法
// 高位相乘时, 计算后面的零的个数
// 注意: stringbuilder使用int作为参数初始化时, 参数表示容量
// 2. https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation

class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        StringBuilder ret = new StringBuilder("0");
        for (int i = 0; i < num1.length(); ++i) {
            for (int j = 0; j < num2.length(); ++j) {
                StringBuilder current = new StringBuilder(
                        String.valueOf((num1.charAt(i) - '0') * (num2.charAt(j) - '0')));
                int zeros = num1.length() - 1 - i + num2.length() - 1 - j;
                char[] ca = new char[zeros];
                Arrays.fill(ca, '0');
                current.append(new String(ca));
                ret = add(ret, current);
            }
        }
        return ret.toString();
    }

    StringBuilder add(StringBuilder s1, StringBuilder s2) {
        StringBuilder ret = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int num1 = 0;
            if (i >= 0) {
                num1 = s1.charAt(i) - '0';
            }
            int num2 = 0;
            if (j >= 0) {
                num2 = s2.charAt(j) - '0';
            }
            int sum = num1 + num2 + carry;
            ret.insert(0, sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        if (carry == 1) {
            ret.insert(0, "1");
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().multiply("123", "456"));
    }
}