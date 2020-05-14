package com.fhlxc.mylove;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年5月13日 上午10:54:31
* @classname LeetCodeInput
* @description
*/

public class LeetCodeInput {
    
    private static char[] cs;
    
    public static String read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String tmp = reader.readLine();
        String s = "";
        do {
            s += tmp;
            tmp = reader.readLine();
        } while (!tmp.equals("."));
        return s;
    }
    
    public static List<List<Integer>> stringToLLInteger(String input) {
        List<List<Integer>> result = new ArrayList<>();
        String[] inputs = input.split("],");
        for (String s: inputs) {
            cs = s.toCharArray();
            List<Integer> tmp = new ArrayList<>();
            for (char c: cs) {
                if (c >= 48 && c <= 57) {
                    tmp.add(c - 48);
                }
            }
            result.add(tmp);
        }
        return result;
    }
    
    public static int[] stringToArray(String input) {
        input = input.substring(1, input.length() - 1);
        String[] ns = input.split(",");
        int[] numbers = new int[ns.length];
        for (int i = 0; i < ns.length; i++) {
            numbers[i] = Integer.parseInt(ns[i]);
        }
        return numbers;
    }

}
