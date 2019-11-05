package _263_ugly_number;
/*
 * @Author: your name
 *
 * @Date: 2019-11-04 16:32:24
 *
 * @LastEditTime: 2019-11-04 16:36:09
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_263_ugly_number/Solution.java
 */

// https://leetcode.com/problems/ugly-number/

// 思路:
// 不断地除以2, 3, 5, 如果为1, 则为ugly number
// 注意: 处理0的情况

class Solution {
    public boolean isUgly(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}