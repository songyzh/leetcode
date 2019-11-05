package _278_first_bad_version;
/*
 * @Author: your name
 * @Date: 2019-11-04 19:02:44
 * @LastEditTime: 2019-11-05 13:27:04
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/_278_first_bad_version/Solution.java
 */

// https://leetcode.com/problems/first-bad-version/

// 思路:
// 二分查找

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

class VersionControl {
    boolean isBadVersion(int version) {
        return true;
    }
}

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}