package com.fhlxc.week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年5月11日 上午10:16:57
* @classname GetRow
* @description
* 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
* 在杨辉三角中，每个数是它左上方和右上方的数的和。
* 示例:
* 输入: 3
* 输出: [1,3,3,1]
*/

public class GetRow {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex < 0) {
            return result;
        }
        result.add(1);
        int i = 0;
        int j = 0;
        int n1 = 0, n2 = 0;
        for (int k = 0; k < rowIndex; k++) {
            i = 0;
            j = result.size();
            for (; i <= j; i++) {
                if (i - 1 < 0) {
                    n1 = 0;
                    n2 = result.get(0);
                }
                if (i == j) {
                    n1 = result.get(j - 1);
                    n2 = 0;
                }
                if (i - 1 >= 0 && i < j) {
                    n1 = result.get(i - 1);
                    n2 = result.get(i);
                }
                result.add(n1 + n2);
            }
            for (int m = 0; m < j; m++) {
                result.remove(0);
            }
        }
        return result;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.out.println(new GetRow().getRow(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())));
    }

}
