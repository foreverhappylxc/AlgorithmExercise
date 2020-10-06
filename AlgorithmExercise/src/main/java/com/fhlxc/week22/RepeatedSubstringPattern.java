package com.fhlxc.week22;

import java.io.IOException;

import com.fhlxc.mylove.LeetCodeInput;

/**
* @author Xingchao Long
* @date 2020年8月24日
* @classname RepeatedSubstringPattern
* @description
* 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
* 示例 1:
* 输入: "abab"
* 输出: True
* 解释: 可由子字符串 "ab" 重复两次构成。
* 示例 2:
* 输入: "aba"
* 输出: False
* 示例 3:
* 输入: "abcabcabcabc"
* 输出: True
* 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
*/

public class RepeatedSubstringPattern {
    
    private boolean equalN(char[] ss, int step) {
        
        int i = 0;
        int j = 0;
        
        for (; i < step; i++) {
            j = i;
            
            for (; j < ss.length; j += step) {
                if (j + step >= ss.length) {
                    break;
                }
                if (ss[j] != ss[j + step]) {
                    return false;
                }
            }
            
        }
        
        if (j != ss.length - 1) {
            return false;
        }
        
        return true;
    }
    
    public boolean repeatedSubstringPattern(String s) {
        char[] ss = s.toCharArray();
        for (int i = 1; i  < s.length(); i++) {
            if (equalN(ss, i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern(LeetCodeInput.stringToString(LeetCodeInput.read())));
    }

}
