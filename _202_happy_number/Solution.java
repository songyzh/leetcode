package _202_happy_number;
/*
 * @Author: your name
 *
 * @Date: 2019-11-01 08:26:58
 *
 * @LastEditTime: 2019-11-01 08:34:51
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_202_happy_number/Solution.java
 */

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/happy-number/

// 思路:
// 不是happy number的数字, 会进入一个循环. 可以把每次的结果存在一个set中, 如果遇到重复的, 则不是
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            n = helper(n);
        }
        return true;
    }

    int helper(int n) {
        int ret = 0;
        while (n != 0) {
            ret += Math.pow(n % 10, 2);
            n /= 10;
        }
        return ret;
    }
}