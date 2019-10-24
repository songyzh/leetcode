package _66_plus_one;
/*
 * @Author: your name
 * @Date: 2019-10-22 20:18:05
 * @LastEditTime: 2019-10-22 21:03:38
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_66_plus_one/Solution.java
 */

import java.util.Arrays;

// https://leetcode.com/problems/plus-one/

// 思路:
// 从后往前处理
// 考虑进位
// 考虑最后可能要加一位

class Solution {
    public int[] plusOne(int[] digits) {
        int plus = 1;
        for (int i = digits.length - 1; i >= 0; --i) {
            int sum = digits[i] + plus;
            int current = sum % 10;
            digits[i] = current;
            plus = sum / 10;
        }
        if (plus == 1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 1; i < newDigits.length; ++i) {
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne(new int[] { 1, 2, 3, 4 })));
        System.out.println(Arrays.toString(new Solution().plusOne(new int[] { 9, 9, 9, 9 })));
    }
}