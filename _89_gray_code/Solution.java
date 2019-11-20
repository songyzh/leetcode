package _89_gray_code;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-19 12:46:23
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-19 13:12:09
 *
 * @FilePath: /leetcode/_89_gray_code/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

import java.util.ArrayList;

// https://leetcode.com/problems/gray-code/

import java.util.List;

// 思路:
// 递归, 找到n-1和n之间的规律

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        if (n == 0) {
            ret.add(0);
            return ret;
        }
        if (n == 1) {
            ret.add(0);
            ret.add(1);
            return ret;
        }
        List<Integer> prev = grayCode(n - 1);
        for (int i = 0; i < prev.size(); ++i) {
            int p = prev.get(i);
            if (i % 2 == 0) {
                ret.add(p << 1);
                ret.add(p << 1 | 1);
            } else {
                ret.add(p << 1 | 1);
                ret.add(p << 1);
            }
        }
        return ret;
    }
}