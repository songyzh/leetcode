package _88_merge_sorted_array;
/*
 * @Author: your name
 * @Date: 2019-10-23 18:43:17
 * @LastEditTime: 2019-10-23 19:04:39
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_88_merge_sorted_array/Solution.java
 */

// https://leetcode.com/problems/merge-sorted-array/

// 思路:
// 从后往前排序

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (k >= 0) {
            if (i < 0) {
                nums1[k--] = nums2[j--];
            } else if (j < 0) {
                nums1[k--] = nums1[i--];
            } else {
                if (nums1[i] > nums2[j]) {
                    nums1[k--] = nums1[i--];
                } else {
                    nums1[k--] = nums2[j--];
                }
            }
        }
    }
}