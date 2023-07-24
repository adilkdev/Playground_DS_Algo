package com.adil.ds_algo.arrays.medium;

/**
 * Given an integer array nums, find the contiguous sub array (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * A sub array is a contiguous part of an array.
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6
 */

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int maxSum = 0;

        for(int i=1; i<nums.length; i++) {
            curSum = curSum + nums[i];
            if (curSum < 0)
                curSum = 0;
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }

}
