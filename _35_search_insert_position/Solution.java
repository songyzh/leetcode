package _35_search_insert_position;
/*
 * @Author: your name
 * @Date: 2019-10-21 08:21:43
 * @LastEditTime: 2019-10-21 08:27:17
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_35_search_insert_position/Solution.java
 */

// https://leetcode.com/problems/search-insert-position/

// 思路:
// 遍历数组
// 默认插入位置为尾端
// 如果遇到current == target, 则返回current的index
// 如果遇到第一个current > target, 则返回current的index

class Solution {
    public int searchInsert(int[] nums, int target) {
        int ret = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            int current = nums[i];
            if (current >= target) {
                return i;
            }
        }
        return ret;
    }
}