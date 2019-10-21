/*
 * @Author: your name
 * @Date: 2019-10-20 23:04:29
 * @LastEditTime: 2019-10-20 23:06:50
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_20_valid_parentheses/Solution.java
 */

// https://leetcode.com/problems/valid-parentheses/

// 思路:
// 把开括号放进栈中
// 遇到关括号, 弹栈, 应为对应的开括号
// 否则返回false

package _20_valid_parentheses;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (c == ')' && top != '(') {
                    return false;
                } else if (c == ']' && top != '[') {
                    return false;
                } else if (c == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}