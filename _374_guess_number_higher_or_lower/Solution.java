package _374_guess_number_higher_or_lower;
/*
 * @Author: your name
 *
 * @Date: 2019-11-08 10:18:44
 *
 * @LastEditTime: 2019-11-08 10:57:09
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_374_guess_number_higher_or_lower/Solution.java
 */

// https://leetcode.com/problems/guess-number-higher-or-lower/

// 思路:
// 二分查找

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

class GuessGame {

    int guess(int num) {
        return 0;
    }

}

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            }
            if (res < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

}