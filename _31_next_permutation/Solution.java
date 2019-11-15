package _31_next_permutation;
/*
 * @Author: your name
 *
 * @Date: 2019-11-15 10:21:27
 *
 * @LastEditTime: 2019-11-15 11:22:17
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_31_next_permutation/Solution.java
 */

// https://leetcode.com/problems/next-permutation/

// 思路:
// 从后往前, 应该是越来越大的, 类似98765这种, 这种可以直接排序即可
// 如果是97685这种, 找到出现问题的数字6, 应变为比其大的最小的数8, 剩下的56按顺序排序
// 注意: 找到badIndex后要break

class Solution {
    int[] nums;

    public void nextPermutation(int[] nums) {
        this.nums = nums;
        int badIndex = -1;
        for (int i = nums.length - 1; i > 0; --i) {
            if (nums[i] > nums[i - 1]) {
                badIndex = i - 1;
                // 记得需要break
                break;
            }
        }
        if (badIndex == -1) {
            quickSort(0, nums.length - 1);
            return;
        }
        // 找到比它大的最小的数
        int nextBigger = badIndex + 1;
        for (int i = badIndex + 1; i < nums.length; ++i) {
            if (nums[i] > nums[badIndex]) {
                nextBigger = i;
            }
        }

        int tmp = nums[nextBigger];
        nums[nextBigger] = nums[badIndex];
        nums[badIndex] = tmp;

        quickSort(badIndex + 1, nums.length - 1);
    }

    void quickSort(int start, int end) {
        if (start >= end) {
            return;
        }
        int val = nums[end];
        int pivot = start - 1;
        for (int i = start; i < end; ++i) {
            if (nums[i] <= val) {
                pivot++;
                int tmp = nums[pivot];
                nums[pivot] = nums[i];
                nums[i] = tmp;
            }
        }
        pivot++;
        nums[end] = nums[pivot];
        nums[pivot] = val;
        quickSort(start, pivot - 1);
        quickSort(pivot + 1, end);
    }

    // public static void main(String[] args) {
    // int[] ia = new int[] { 1, 2, 3 };
    // new Solution().nextPermutation(ia);
    // System.out.println(Arrays.toString(ia));
    // }
}