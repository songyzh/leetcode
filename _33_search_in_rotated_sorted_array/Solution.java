package _33_search_in_rotated_sorted_array;
/*
 * @Author: your name
 *
 * @Date: 2019-11-15 12:25:33
 *
 * @LastEditTime: 2019-11-15 14:20:20
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_33_search_in_rotated_sorted_array/Solution.java
 */

// https://leetcode.com/problems/search-in-rotated-sorted-array/

// 思路:
// 789123456
// 找到中点, 如果某一侧是正常顺序, 且target在其中, 进行二分查找; 否则在另一端找
// 然后二分查找
// https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14425/Concise-O(log-N)-Binary-search-solution

class Solution {
    int ret = -1;
    int target;
    int[] nums;

    public int search(int[] nums, int target) {
        this.target = target;
        this.nums = nums;
        helper(0, nums.length - 1);
        return ret;
    }

    void helper(int start, int end) {
        if (start > end) {
            return;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            ret = mid;
            return;
        }
        if (mid - 1 >= 0 && nums[start] <= nums[mid - 1]) {
            // 左边是排序的
            if (nums[start] <= target && target <= nums[mid - 1]) {
                // 在左边
                binarySearch(start, mid - 1);
            } else {
                // 在右边
                helper(mid + 1, end);
            }
        }
        if (mid + 1 < nums.length && nums[mid + 1] <= nums[end]) {
            // 右边是排序的
            if (nums[mid + 1] <= target && target <= nums[end]) {
                // 在右边
                binarySearch(mid + 1, end);
            } else {
                // 在左边
                helper(start, mid - 1);
            }
        }

    }

    void binarySearch(int start, int end) {
        if (start > end) {
            return;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            ret = mid;
            return;
        }
        if (nums[mid] > target) {
            binarySearch(start, mid - 1);
        } else {
            binarySearch(mid + 1, end);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[] { 1, 3 }, 3));
    }

}