package _26_remove_duplicates_from_sorted_array;
/*
 * @Author: your name
 * @Date: 2019-10-20 23:17:10
 * @LastEditTime: 2019-10-20 23:30:09
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_26_remove_duplicates_from_sorted_array/Solution.java
 */

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

// 思路:
// 从左向右
// 先找到应该插入新值的位置
// 其次找到应插入的新值

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        // 记录最后一个不重复的数
        int index = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[index]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }
}