package _71_simplify_path;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-17 12:16:23
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-17 14:03:23
 *
 * @FilePath: /leetcode/_71_simplify_path/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

import java.util.Stack;

// https://leetcode.com/problems/simplify-path/

// 思路:
// 使用栈处理

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String s : path.split("/")) {
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (s.length() > 0 && !s.equals(".")) {
                stack.add(s);
            }
        }
        return "/" + String.join("/", stack);
    }
}