package _179_largest_number;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-21 15:25:34
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-21 15:42:05
 *
 * @FilePath: /leetcode/_179_largest_number/Solution.java
 *
 * @Github: https://github.com/songyzh
 */
// https://leetcode.com/problems/largest-number/

// 思路:
// 先排序, 后合并起来
// 考虑数字越界

class Solution {
    public String largestNumber(int[] nums) {
        List<Integer> lst = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(lst, (num1, num2) -> {
            String v1 = num1.toString() + num2.toString();
            String v2 = num2.toString() + num1.toString();
            return v2.compareTo(v1);
        });
        StringBuilder sb = new StringBuilder();
        lst.stream().forEach(sb::append);
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}