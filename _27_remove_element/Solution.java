package _27_remove_element;
/*
 * @Author: your name
 * @Date: 2019-10-20 23:28:30
 * @LastEditTime: 2019-10-20 23:35:08
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_27_remove_element/Solution.java
 */

// https://leetcode.com/problems/remove-element/

// 思路:
// 遇到要移除的数时, 将其移到最后
// 同时右边界左移1

class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}