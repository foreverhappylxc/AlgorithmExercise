package com.fhlxc.week20;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.fhlxc.mylove.LeetCodeInput;

/**
* @author Xingchao Long
* @date 2020年5月18日 上午10:41:53
* @classname LadderLength
* @description
*/

public class LadderLength {

    private boolean oneDiffer(String str1, String str2) {
        int num = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                num++;
                if (num >= 2) {
                    return false;
                }
            }
        }
        if (num == 0) {
            return false;
        }
        return true;
    }
    
    private int findNext(List<Integer> list, int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (!list.contains(i) && list.contains(j) && map[i][j] == 1) {
                    return j;
                }
            }
        }
        return -1;
    }
    
    private int shortPath(int i, int j, int[][] map) {
        int[] distance = new int[map.length];
        List<Integer> list = new LinkedList<Integer>();
        for (int k = 0; k < map.length; k++) {
            list.add(k + 1);
        }
        list.remove(Integer.valueOf(i));
        int next = 0;
        for (int k = 0; k < map.length; k++) {
            distance[k] = map[i][k];
        }
        while (!list.isEmpty()) {
            next = findNext(list, map);
            if (next == -1) {
                break;
            }
            for (int k = 0; k < map.length; k++) {
                if (map[next][k] != Integer.MAX_VALUE) {
                    if (distance[next] != Integer.MAX_VALUE) {
                        distance[k] = Math.min(distance[k], distance[next] + map[next][k]);
                    }
                }
                
            }
            list.remove(Integer.valueOf(next));
        }
        return distance[j];
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int[][] map = new int[wordList.size()][wordList.size()];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (i == j) {
                    map[i][j] = 0;
                } else {
                    if (oneDiffer(wordList.get(i), wordList.get(j))) {
                        map[i][j] = 1;
                    } else {
                        map[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int tmp = 0;
        for (String s: wordList) {
            if (oneDiffer(s, beginWord)) {
                tmp = shortPath(wordList.indexOf(s), wordList.indexOf(endWord), map);
                if (min > tmp) {
                    min = tmp;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min + 2;
    }
    
    public static void main(String[] args) throws IOException {
        System.out.println(new LadderLength().ladderLength(LeetCodeInput.stringToString(LeetCodeInput.read()), LeetCodeInput.stringToString(LeetCodeInput.read()), LeetCodeInput.stringToLString(LeetCodeInput.read())));
    }

}
