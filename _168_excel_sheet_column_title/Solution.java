package _168_excel_sheet_column_title;
/*
 * @Author: your name
 *
 * @Date: 2019-10-26 20:26:59
 *
 * @LastEditTime: 2019-10-26 22:05:46
 *
 * @LastEditors: Please set LastEditors
 *
 * @Description: In User Settings Edit
 *
 * @FilePath: /leetcode/_168_excel_sheet_column_title/Solution.java
 */

// https://leetcode.com/problems/excel-sheet-column-title/

// 思路:
// 类似十进制转26进制, 需要额外处理没有0的情况
// 最后一位: num % 26 + 'A' - 1
// num /= 26, 继续这个过程

class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n /= 26;
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(27));
    }
}