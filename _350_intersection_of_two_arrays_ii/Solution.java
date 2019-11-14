package _350_intersection_of_two_arrays_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author: your name
 *
 * @Date: 2019-11-07 20:34:09
 *
 * @LastEditTime: 2019-11-08 09:20:46
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_350_intersection_of_two_arrays_ii/Solution.java
 */
// https://leetcode.com/problems/intersection-of-two-arrays-ii/

// 思路:
// 1. 两数组排序, 从前往后遍历
// 2. 使用map分别统计元素出现的次数

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ret = new ArrayList<>();
        Map<Integer, Integer> lookup = new HashMap<>();
        for (int i = 0; i < nums1.length; ++i) {
            int num = nums1[i];
            if (lookup.containsKey(num)) {
                lookup.put(num, lookup.get(num) + 1);
            } else {
                lookup.put(num, 1);
            }
        }
        for (int i = 0; i < nums2.length; ++i) {
            int num = nums2[i];
            if (lookup.containsKey(num) && lookup.get(num) > 0) {
                ret.add(num);
                // 抵消掉一次出现
                lookup.put(num, lookup.get(num) - 1);
            }
        }
        int[] ret1 = new int[ret.size()];
        int index = 0;
        for (int num : ret) {
            ret1[index++] = num;
        }
        return ret1;
    }
}