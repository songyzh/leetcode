package _155_min_stack;
/*
 * @Author: your name
 *
 * @Date: 2019-10-26 15:56:27
 *
 * @LastEditTime: 2019-10-26 16:10:29
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_155_min_stack/Solution.java
 */

import java.util.Stack;

// https://leetcode.com/problems/min-stack/

// 思路:
// 可以用通常的stack保存数据
// 使用单独字段保存min

class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> stack;

    public MinStack() {
        if (this.stack == null) {
            this.stack = new Stack<>();
        }
    }

    public void push(int x) {
        this.stack.add(x);
    }

    public void pop() {
        this.stack.pop();
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        int ret = Integer.MAX_VALUE;
        for (Integer i : this.stack) {
            if (i <= ret) {
                ret = i;
            }
        }
        return ret;
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */