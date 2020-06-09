package com.fhlxc.week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年5月11日 上午9:54:04
* @classname Generate
* @description
* 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
* 在杨辉三角中，每个数是它左上方和右上方的数的和。
* 示例:
* 输入: 5
* 输出:
* [
*      [1],
*     [1,1],
*    [1,2,1],
*   [1,3,3,1],
*  [1,4,6,4,1]
* ]
*/

public class Generate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> one = new ArrayList<>();
        one.add(1);
        result.add(one);
        int n;
        int n1 = 0;
        int n2 = 0;
        for (int i = 1; i < numRows; i++) {
            one = result.get(result.size() - 1);
            n = one.size();
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                if (j - 1 < 0) {
                    n1 = 0;
                    n2 = one.get(0);
                }
                if (j == n) {
                    n1 = one.get(n - 1);
                    n2 = 0;
                }
                if (j - 1 >= 0 && j < n) {
                    n1 = one.get(j - 1);
                    n2 = one.get(j);
                }
                tmp.add(n1 + n2);
            }
            result.add(tmp);
        }
        return result;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.out.println(new Generate().generate(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())));
    }

}
