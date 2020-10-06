package com.fhlxc.week22;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fhlxc.mylove.LeetCodeInput;

/**
* @author Xingchao Long
* @date 2020年8月19日
* @classname CountSubstrings
* @description
* 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
* 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
* 示例 1：
* 输入："abc"
* 输出：3
* 解释：三个回文子串: "a", "b", "c"
* 示例 2：
* 输入："aaa"
* 输出：6
* 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
*/

public class CountSubstrings {
    
    private int count(String s1, String s2) {
        int count = 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int length = c1.length > c2.length ? c2.length : c1.length;
        for (int i = 0; i < length; i++) {
            if (c1[c1.length - 1 - i] == c2[i]) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public int countSubstrings(String s) {
        int result = 0;
        int count = 1;
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        String string = "" + chars[0];
        List<String> list = new ArrayList<>();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
                string += chars[i];
            } else {
                result = result + (count + 1) * count / 2;
                count = 1;
                list.add(string);
                string = "" + chars[i];
            }
        }
        result = result + (count + 1) * count / 2;
        list.add(s.substring(chars.length - count));
        int length = list.size() - 1;
        for (int i = 1; i < length; i++) {
            for (int j = 1; j <= (i < length - i ? i : length - i); j++) {
                String s1 = list.get(i - j);
                String s2 = list.get(i + j);
                if (s1.equals(s2)) {
                    result = result + s1.length();
                } else {
                    result = result + count(s1, s2);
                    break;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        System.out.println(new CountSubstrings().countSubstrings(LeetCodeInput.stringToString(LeetCodeInput.read())));
    }

}
