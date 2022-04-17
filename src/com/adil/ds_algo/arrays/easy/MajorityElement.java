package com.adil.ds_algo.arrays.easy;

/**
 * https://leetcode.com/problems/majority-element/
 * solution : https://www.youtube.com/watch?v=X0G5jEcvroo
 * moore's voting algorithm is used to solve the problem
 */

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int element = nums[0];
        int count = 1;

        for(int i=1; i<nums.length; i++) {
            if(nums[i] == element) {
                count++;
            } else {
                count--;
            }

            if(count == 0) {
                element = nums[i];
                count = 1;
            }
        }

        return element;
    }

}
