package com.fhlxc.week22;

import java.io.IOException;

import com.fhlxc.mylove.LeetCodeInput;

/**
* @author Xingchao Long
* @date 2020年9月2日
* @classname IsNumber
* @description
* 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
*/

public class IsNumber {

    public boolean isNumber(String s) {
        if (s.contains("f") || s.contains("F") || s.contains("d") || s.contains("D")) {
            return false;
        }
        try {
            Float.parseFloat(s);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        System.out.println(new IsNumber().isNumber(LeetCodeInput.stringToString(LeetCodeInput.read())));
    }

}
