package com.fhlxc.week19;

import java.io.IOException;
import java.util.List;

import com.fhlxc.mylove.LeetCodeInput;

/**
* @author Xingchao Long
* @date 2020年5月13日 上午10:51:06
* @classname MinimumTotal
* @description
* 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
* 例如，给定三角形：
* [
*      [2],
*     [3,4],
*    [6,5,7],
*   [4,1,8,3]
* ]
* 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
* 说明：
* 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
*/

public class MinimumTotal {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        List<Integer> tmp;
        List<Integer> pre;
        for (int i = triangle.size() - 1; i > 0; i--) {
            tmp = triangle.get(i);
            pre = triangle.get(i - 1);
            for (int j = 0; j < tmp.size() - 1; j++) {
                pre.set(j, Math.min(tmp.get(j) + pre.get(j), tmp.get(j + 1) + pre.get(j)));
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) throws IOException {
        String input = LeetCodeInput.read();
        System.out.println(new MinimumTotal().minimumTotal(LeetCodeInput.stringToLLInteger(input)));
    }

}
