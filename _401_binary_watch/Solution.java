package _401_binary_watch;
/*
 * @Author: your name
 *
 * @Date: 2019-11-08 17:33:32
 *
 * @LastEditTime: 2019-11-10 22:11:24
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_401_binary_watch/Solution.java
 */

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-watch/

// 思路:
// 回溯算法

class Solution {
    List<String> ret = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        List<Integer> current = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            current.add(0);
        }
        helper(current, num);
        return ret;
    }

    void helper(List<Integer> current, int onesToAdd) {
        if (onesToAdd == 0) {
            String res = calc(current);
            if (res != null) {
                ret.add(res);
            }
            return;
        }
        int lastOne = current.lastIndexOf(1);
        for (int i = 0; i < current.size(); ++i) {
            if (current.get(i) == 0 && i > lastOne) {
                List<Integer> currentCopy = new ArrayList<>(current);
                currentCopy.set(i, 1);
                helper(currentCopy, onesToAdd - 1);
            }
        }
    }

    private String calc(List<Integer> digits) {
        int hour = 0;
        int minute = 0;
        if (digits.get(0) == 1) {
            hour += 8;
        }
        if (digits.get(1) == 1) {
            hour += 4;
        }
        if (digits.get(2) == 1) {
            hour += 2;
        }
        if (digits.get(3) == 1) {
            hour += 1;
        }
        if (hour > 11) {
            return null;
        }
        if (digits.get(4) == 1) {
            minute += 32;
        }
        if (digits.get(5) == 1) {
            minute += 16;
        }
        if (digits.get(6) == 1) {
            minute += 8;
        }
        if (digits.get(7) == 1) {
            minute += 4;
        }
        if (digits.get(8) == 1) {
            minute += 2;
        }
        if (digits.get(9) == 1) {
            minute += 1;
        }
        if (minute > 59) {
            return null;
        }
        return hour + ":" + String.format("%02d", minute);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().readBinaryWatch(1));
    }

}