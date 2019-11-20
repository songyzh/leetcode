package _80_remove_duplicates_from_sorted_array_ii;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-18 20:26:58
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-18 21:27:44
 *
 * @FilePath: /leetcode/_80_remove_duplicates_from_sorted_array_ii/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

import java.util.Arrays;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

// 思路:
// 把数组想象为两个, 用已有的去填充新的, 则可以填充的条件为 nums[i] != nums[index - 2]

class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (index < 2 || nums[index - 2] != num) {
                nums[index++] = num;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] ia = new int[] { 1, 1, 1, 2, 2, 3 };
        System.out.println(new Solution().removeDuplicates(ia));
        System.out.println(Arrays.toString(ia));

    }
}