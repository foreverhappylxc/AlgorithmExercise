package com.fhlxc.week21;

import java.io.IOException;

import com.fhlxc.mylove.LeetCodeInput;

/**
* @author Xingchao Long
* @date 2020年8月7日
* @classname Candy
* @description
*/

public class Candy {

    private int findMin(int[] ratings) {
        int min = Integer.MAX_VALUE;
        int position = -1;
        for (int i = 0; i < ratings.length; i++) {
            if (ratings[i] < 0) {
                continue;
            }
            if (min > ratings[i]) {
                min = ratings[i];
                position = i;
            }
        }
        if (position != -1) {
            ratings[position] = -ratings[position];
        }
        return position;
    }
    
    public int candy(int[] ratings) {
        int result = 0;
        int[] nums = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            ratings[i]++;
        }
        int position;
        if (ratings.length == 1) {
            return 1;
        }
        while ((position = findMin(ratings)) != -1) {
            nums[position] = 1;
            if (position - 1 >= 0 && position + 1 < ratings.length) {
                if (ratings[position - 1] < 0 && ratings[position + 1] < 0) {
                    if (Math.abs(ratings[position - 1]) < Math.abs(position + 1)) {
                        if (Math.abs(ratings[position]) < Math.abs(ratings[position - 1])) {
                            if (nums[position] >= nums[position - 1]) {
                                nums[position - 1] = nums[position] + 1;
                            }
                        }
                        if (Math.abs(ratings[position]) > Math.abs(ratings[position - 1])) {
                            if (nums[position - 1] >= nums[position]) {
                                nums[position] = nums[position - 1] + 1;
                            }
                        }
                        if (Math.abs(ratings[position]) < Math.abs(ratings[position + 1])) {
                            if (nums[position] >= nums[position + 1]) {
                                nums[position + 1] = nums[position] + 1;
                            }
                        }
                        if (Math.abs(ratings[position]) > Math.abs(ratings[position + 1])) {
                            if (nums[position + 1] >= nums[position]) {
                                nums[position] = nums[position + 1] + 1;
                            }
                        }
                    } else {
                        if (Math.abs(ratings[position]) < Math.abs(ratings[position + 1])) {
                            if (nums[position] >= nums[position + 1]) {
                                nums[position + 1] = nums[position] + 1;
                            }
                        }
                        if (Math.abs(ratings[position]) > Math.abs(ratings[position + 1])) {
                            if (nums[position + 1] >= nums[position]) {
                                nums[position] = nums[position + 1] + 1;
                            }
                        }
                        if (Math.abs(ratings[position]) < Math.abs(ratings[position - 1])) {
                            if (nums[position] >= nums[position - 1]) {
                                nums[position - 1] = nums[position] + 1;
                            }
                        }
                        if (Math.abs(ratings[position]) > Math.abs(ratings[position - 1])) {
                            if (nums[position - 1] >= nums[position]) {
                                nums[position] = nums[position - 1] + 1;
                            }
                        }
                    }
                } 
                if (ratings[position - 1] < 0 && ratings[position + 1] > 0) {
                    if (Math.abs(ratings[position]) < Math.abs(ratings[position - 1])) {
                        if (nums[position] >= nums[position - 1]) {
                            nums[position - 1] = nums[position] + 1;
                        }
                    }
                    if (Math.abs(ratings[position]) > Math.abs(ratings[position - 1])) {
                        if (nums[position - 1] >= nums[position]) {
                            nums[position] = nums[position - 1] + 1;
                        }
                    }
                }
                if (ratings[position - 1] > 0 && ratings[position + 1] < 0) {
                    if (Math.abs(ratings[position]) < Math.abs(ratings[position + 1])) {
                        if (nums[position] >= nums[position + 1]) {
                            nums[position + 1] = nums[position] + 1;
                        }
                    }
                    if (Math.abs(ratings[position]) > Math.abs(ratings[position + 1])) {
                        if (nums[position + 1] >= nums[position]) {
                            nums[position] = nums[position + 1] + 1;
                        }
                    }
                }
            }
            if (position == 0 && ratings[position + 1] < 0) {
                if (Math.abs(ratings[position]) < Math.abs(ratings[position + 1])) {
                    if (nums[position] >= nums[position + 1]) {
                        nums[position + 1] = nums[position] + 1;
                    }
                }
                if (Math.abs(ratings[position]) > Math.abs(ratings[position + 1])) {
                    if (nums[position + 1] >= nums[position]) {
                        nums[position] = nums[position + 1] + 1;
                    }
                }
            }
            if (position == ratings.length - 1 && ratings[position - 1] < 0) {
                if (Math.abs(ratings[position]) < Math.abs(ratings[position - 1])) {
                    if (nums[position] >= nums[position - 1]) {
                        nums[position - 1] = nums[position] + 1;
                    }
                }
                if (Math.abs(ratings[position]) > Math.abs(ratings[position - 1])) {
                    if (nums[position - 1] >= nums[position]) {
                        nums[position] = nums[position - 1] + 1;
                    }
                }
            }
        }
        for (int i: nums) {
            result += i;
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        int[] nums = LeetCodeInput.stringToArray(LeetCodeInput.read());
        System.out.println(new Candy().candy(nums));
    }

}
