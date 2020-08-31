package com.fhlxc.week22;

import java.io.IOException;

import com.fhlxc.mylove.LeetCodeInput;

/**
* @author Xingchao Long
* @date 2020年8月24日
* @classname RepeatedSubstringPattern
* @description
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
