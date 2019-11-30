package _165_compare_version_numbers;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-21 11:48:04
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-21 12:04:15
 *
 * @FilePath: /leetcode/_165_compare_version_numbers/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

// https://leetcode.com/problems/compare-version-numbers/

// 思路:
// 逐级比较

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");
        int i = 0;
        for (i = 0; i < Math.min(v1s.length, v2s.length); ++i) {
            Integer v1 = Integer.parseInt(v1s[i]);
            Integer v2 = Integer.parseInt(v2s[i]);
            if (v1 == v2) {
                continue;
            }
            return Integer.compare(v1, v2);
        }
        for (int j = i; j < v1s.length; ++j) {
            if (Integer.parseInt(v1s[j]) > 0) {
                return 1;
            }
        }
        for (int j = i; j < v2s.length; ++j) {
            if (Integer.parseInt(v2s[j]) > 0) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().compareVersion("01", "1"));
    }
}