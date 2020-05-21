package com.fhlxc.week20;

import java.io.IOException;

import com.fhlxc.mylove.LeetCodeInput;

/**
* @author Xingchao Long
* @date 2020年5月21日 上午10:29:27
* @classname SingleNumber
* @description
* 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
* 说明：
* 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
* 示例 1:
* 输入: [2,2,1]
* 输出: 1
* 示例 2:
* 输入: [4,1,2,1,2]
* 输出: 4
*/

public class SingleNumber {

    public int singleNumber(int[] nums) {
        boolean one = true;
        int j;
        for (int i = 0; i < nums.length; i += 2) {
            one = true;
            j = i + 1;
            for (; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    one = false;
                    break;
                }
            }
            if (one) {
                return nums[i];
            } else {
                nums[j] = nums[i + 1];
                nums[i + 1] = nums[i];
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        try {
            System.out.println(new SingleNumber().singleNumber(LeetCodeInput.stringToArray(LeetCodeInput.read())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
