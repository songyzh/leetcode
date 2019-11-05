package _258_add_digits;
/*
 * @Author: your name
 *
 * @Date: 2019-11-04 16:07:02
 *
 * @LastEditTime: 2019-11-04 16:11:43
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_258_add_digits/Solution.java
 */

// https://leetcode.com/problems/add-digits/

// 思路:
// 在循环中处理

class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            int tmp = 0;
            while (num > 0) {
                tmp += num % 10;
                num /= 10;
            }
            num = tmp;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addDigits(38));
    }
}