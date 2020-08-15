package com.fhlxc.week22;

import java.io.IOException;

import com.fhlxc.mylove.LeetCodeInput;

/**
* @author Xingchao Long
* @date 2020年8月11日
* @classname SingleNumber
* @description
* 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
* 说明：
* 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
* 示例 1:
* 输入: [2,2,3,2]
* 输出: 3
* 示例 2:
* 输入: [0,1,0,1,0,1,99]
* 输出: 99
*/

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int i = 0;
        boolean swap = false;
        int tmp = 0;
        for (; i < nums.length; ) {
            swap = false;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    i++;
                    tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    swap = true;
                    
                }
            }
            if (!swap) {
                break;
            }
            i++;
        }
        return nums[i];
    }
    
    public static void main(String[] args) throws IOException {
        System.out.println(new SingleNumber().singleNumber(LeetCodeInput.stringToArray(LeetCodeInput.read())));
    }

}
