package com.fhlxc.week22;

import java.io.IOException;

import com.fhlxc.mylove.LeetCodeInput;

/**
* @author Xingchao Long
* @date 2020年8月10日
* @classname CountBinarySubstrings
* @description
* 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
* 重复出现的子串要计算它们出现的次数。
* 示例 1 :
* 输入: "00110011"
* 输出: 6
* 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
* 请注意，一些重复出现的子串要计算它们出现的次数。
* 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
* 示例 2 :
* 输入: "10101"
* 输出: 4
* 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
*/

public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        int result = 0;
        char[] ss = s.toCharArray();
        if (ss.length <= 1) {
            return 0;
        }
        int left = 1;
        int right = 0;
        char c = ss[0];
        boolean change = false;
        out: for (int i = 0; i < ss.length; ) {
            for (int j = i + 1; j < ss.length; j++) {
                if (ss[j] == c) {
                    if (!change) {
                        left++;
                    } else {
                        change = false;
                        c = ss[j - 1];
                        i = i + left;
                        result += left > right ? right : left;
                        left = 1;
                        right = 0;
                        break;
                    }
                }
                if (ss[j] != c) {
                    right++;
                    change = true;
                }
                if (i + left + right == ss.length) {
                    break out;
                }
            }
        }
        result += left > right ? right : left;
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        System.out.println(new CountBinarySubstrings().countBinarySubstrings(LeetCodeInput.stringToString(LeetCodeInput.read())));
    }

}
