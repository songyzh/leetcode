package _349_intersection_of_two_arrays;
/*
 * @Author: your name
 *
 * @Date: 2019-11-07 18:14:09
 *
 * @LastEditTime: 2019-11-07 21:02:46
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_349_intersection_of_two_arrays/Solution.java
 */

// https://leetcode.com/problems/intersection-of-two-arrays/

import java.util.HashSet;
import java.util.Set;

// 思路:
// 1. 放入set中去重

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> ret = new HashSet<>();

        Set<Integer> s1 = new HashSet<>();
        for (int num1 : nums1) {
            s1.add(num1);
        }
        for (int num2 : nums2) {
            if (s1.contains(num2)) {
                ret.add(num2);
            }
        }
        int[] ret1 = new int[ret.size()];
        int idx = 0;
        for (int i : ret) {
            ret1[idx++] = i;
        }
        return ret1;
    }
}