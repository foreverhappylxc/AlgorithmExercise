package com.fhlxc.week19;

import java.io.IOException;

import com.fhlxc.mylove.LeetCodeInput;

/**
* @author Xingchao Long
* @date 2020年5月16日 上午10:53:53
* @classname IsPalindrome
* @description
* 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
* 说明：本题中，我们将空字符串定义为有效的回文串。
* 示例 1:
* 输入: "A man, a plan, a canal: Panama"
* 输出: true
* 示例 2:
* 输入: "race a car"
* 输出: false
*/

public class IsPalindrome {

    public boolean isPalindrome(String s) {
        String str = "";
        s = s.toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 48 && c <= 57) || (c >= 65 && c <= 90)) {
                str += c;
            }
        }
        int length = str.length();
        int left = 0;
        int right = 0;
        if (length % 2 == 0) {
            length = length / 2;
            right = length;
            left = right - 1;
            for (int i = 0; i < length; i++) {
                if (str.charAt(left - i) != str.charAt(right + i)) {
                    return false;
                }
            }
        } else {
            length = length / 2;
            left = length - 1;
            right = length + 1;
            for (int i = 0; i < length; i++) {
                if (str.charAt(left - i) != str.charAt(right + i)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        try {
            System.out.println(new IsPalindrome().isPalindrome(LeetCodeInput.stringToString(LeetCodeInput.read())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
