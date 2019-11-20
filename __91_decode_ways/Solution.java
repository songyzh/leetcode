package __91_decode_ways;
/*
 * @Description:
 *
 * @Author: syzh
 *
 * @Date: 2019-11-19 13:19:40
 *
 * @LastEditors: syzh
 *
 * @LastEditTime: 2019-11-19 16:56:19
 *
 * @FilePath: /leetcode/_91_decode_ways/Solution.java
 *
 * @Github: https://github.com/songyzh
 */

// https://leetcode.com/problems/decode-ways/

// 思路:
// 递归
// 2. https://leetcode.com/problems/decode-ways/discuss/253018/Python%3A-Easy-to-understand-explanation-bottom-up-dynamic-programming

class Solution {

    public int numDecodings(String s) {
        int pp = 0;
        int p = 1;
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            int cur = s.charAt(i) == '0' ? 0 : p;
            if (i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
                cur += pp;
            pp = p;
            p = cur;
        }
        return s.length() == 0 ? 0 : p;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("12"));
    }
}