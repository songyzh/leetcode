package _371_sum_of_two_integers;
/*
 * @Author: your name
 *
 * @Date: 2019-11-08 09:41:00
 *
 * @LastEditTime: 2019-11-08 10:18:24
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_371_sum_of_two_integers/Solution.java
 */

// https://leetcode.com/problems/sum-of-two-integers/

// 思路:
// 使用位运算计算加法
// 二进制加法,
// 某位上如果是(0, 0), 结果为0
// 某位上如果是(0, 1), 结果为1
// 某位上如果是(1, 1), 结果为0, 其左边一位为1
// 观察可知, 本位上的结果, 与xor相同; 左边的结果, 与and相同
// 于是可把加法拆分为若干步骤

class Solution {
    public int getSum(int a, int b) {
        // a保存xor结果
        // b保存and结果
        while (a != 0 && b != 0) {
            int tmp = a ^ b;
            b = (a & b) << 1;
            a = tmp;
        }
        return a == 0 ? b : a;
    }
}