package _217_contains_duplicate;
/*
 * @Author: your name
 *
 * @Date: 2019-11-03 10:46:32
 *
 * @LastEditTime: 2019-11-03 10:48:57
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_217_contains_duplicate/Solution.java
 */

// https://leetcode.com/problems/contains-duplicate/

import java.util.HashSet;
import java.util.Set;

// 思路:
// 1. 放入set中, 看是否减少了
// 2. 排序, 逐一查找

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() != nums.length;
    }
}