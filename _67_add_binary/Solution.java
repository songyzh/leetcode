package _67_add_binary;
/*
 * @Author: your name
 * @Date: 2019-10-23 08:32:50
 * @LastEditTime: 2019-10-23 08:45:37
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_67_add_binary/Solution.java
 */

// https://leetcode.com/problems/add-binary/

import java.util.ArrayList;

// 思路:
// 从后往前相加
// 考虑进位
// 考虑较长的串的剩余部分
// 考虑最后剩余的进位

class Solution {
    public String addBinary(String a, String b) {
        int index1 = a.length() - 1;
        int index2 = b.length() - 1;
        List<Integer> ret = new ArrayList<>();
        int plus = 0;
        while (index1 >= 0 || index2 >= 0) {
            int num1 = index1 >= 0 ? a.charAt(index1) - '0' : 0;
            int num2 = index2 >= 0 ? b.charAt(index2) - '0' : 0;
            index1--;
            index2--;
            int sum = num1 + num2 + plus;
            int current = sum % 2;
            plus = sum / 2;
            ret.add(0, current);
        }
        if (plus == 1) {
            ret.add(0, 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int num : ret) {
            sb.append(num);
        }
        return sb.toString();
    }
}