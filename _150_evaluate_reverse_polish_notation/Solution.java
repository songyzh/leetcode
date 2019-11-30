package _150_evaluate_reverse_polish_notation;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-20 18:05:16
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-20 18:48:20
 *
 * @FilePath: /leetcode/_150_evaluate_reverse_polish_notation/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/

// 思路:
// 用stack做

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            if (Arrays.asList("+", "-", "*", "/").contains(t)) {
                Integer v2 = stack.pop();
                Integer v1 = stack.pop();
                if ("+".equals(t)) {
                    v1 += v2;
                } else if ("-".equals(t)) {
                    v1 -= v2;
                } else if ("*".equals(t)) {
                    v1 *= v2;
                } else {
                    v1 /= v2;
                }
                stack.push(v1);
            } else {
                stack.add(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}