package _204_count_primes;
/*
 * @Author: your name
 *
 * @Date: 2019-11-02 11:23:05
 *
 * @LastEditTime: 2019-11-02 12:09:54
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_204_count_primes/Solution.java
 */

// https://leetcode.com/problems/count-primes/

// 思路:
// 筛法, 把所有的数存在数组中, 从左到右, 如果遇到素数, 则此素数的倍数位置上的数字为非素数
// 注意, 此题问的是小于n的, 而非小于等于n的

class Solution {
    public int countPrimes(int n) {
        int[] ret = new int[n + 1];
        for (int i = 2; i <= n; ++i) {
            ret[i] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            if (ret[i] == 0) {
                continue;
            }
            for (int j = i * 2; j < n; j += i) {
                ret[j] = 0;
            }
        }
        int res = 0;
        for (int i = 2; i < n; ++i) {
            res += ret[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countPrimes(10));
    }
}