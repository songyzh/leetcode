package _345_reverse_vowels_of_a_string;
/*
 * @Author: your name
 *
 * @Date: 2019-11-07 18:06:24
 *
 * @LastEditTime: 2019-11-07 18:13:05
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_345_reverse_vowels_of_a_string/Solution.java
 */

import java.util.Arrays;

// https://leetcode.com/problems/reverse-vowels-of-a-string/

// 思路:
// 遇到元音时才交换位置, 使用双指针

class Solution {
    public String reverseVowels(String s) {
        char[] ca = s.toCharArray();
        int i = 0;
        int j = ca.length - 1;
        outer: while (i < j) {
            char ci = ca[i];
            char cj = ca[j];
            while (!isVowel(ci)) {
                i++;
                continue outer;
            }
            while (!isVowel(cj)) {
                j--;
                continue outer;
            }
            ca[i++] = cj;
            ca[j--] = ci;
        }
        return new String(ca);
    }

    boolean isVowel(char c) {
        return Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').contains(c);
    }
}