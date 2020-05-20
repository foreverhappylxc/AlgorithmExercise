package com.fhlxc.mylove;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    
    public static String stringToString(String input) {
        return input.substring(1, input.length() - 1);
    }
    
    public static List<List<Integer>> stringToLLInteger(String input) {
        List<List<Integer>> result = new ArrayList<>();
        String[] inputs = input.split("], ?");
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
        String[] ns = input.split(", ?");
        int[] numbers = new int[ns.length];
        for (int i = 0; i < ns.length; i++) {
            numbers[i] = Integer.parseInt(ns[i]);
        }
        return numbers;
    }
    
    public static TreeNode stringToTree(String input) {
        String[] array = input.substring(1, input.length() - 1).split(",");
        if (array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        TreeNode curr = root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int i = 0;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            i++;
            if (i < array.length) {
                if (!array[i].equals("null")) {
                    curr.left = new TreeNode(Integer.parseInt(array[i]));
                    queue.add(curr.left);
                }
            }
            i++;
            if (i < array.length) {
                if (!array[i].equals("null")) {
                    curr.right = new TreeNode(Integer.parseInt(array[i]));
                    queue.add(curr.right);
                }
            }
        }
        return root;
    }
    
    public static List<String> stringToLString(String input) {
        List<String> list;
        input = input.substring(2, input.length() - 2);
        list = Arrays.asList(input.split("\",\""));
        return list;
    }
    
    public static char[][] stringToCCArray(String input) {
        input = input.substring(2, input.length() - 2).replace("\"", "");
        String[] ns = input.split("], ?\\[");
        if (ns.length == 0) {
            return null;
        }
        char[][] out = new char[ns.length][ns[0].split(",").length];
        for (int i = 0; i < ns.length; i++) {
            String[] tmp = ns[i].split(", ?");
            for (int j = 0; j < tmp.length; j++) {
                out[i][j] = tmp[j].charAt(0);
            }
        }
        return out;
    }

}
