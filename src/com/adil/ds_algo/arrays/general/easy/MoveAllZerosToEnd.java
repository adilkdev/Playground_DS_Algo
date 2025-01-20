package com.adil.ds_algo.arrays.general.easy;

/**
 * Input : [0,1,0,-3,12]
 * Output : [1,-3,12,0,0]
 */
public class MoveAllZerosToEnd {
    public int[] moveZeroes(int[] nums) {
        int count = 0;

        for(int i = 0; i< nums.length; i++) {
            if(nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }

        while(count < nums.length)
            nums[count++] = 0;

        return nums;
    }
}
