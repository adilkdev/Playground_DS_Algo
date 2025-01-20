package com.adil.ds_algo.arrays.general.medium;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 * solution -> https://www.youtube.com/watch?v=32Ll35mhWg0
 */

public class DuplicateNumber {

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        /**
         * first intersection
         */
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(fast != slow);

        /**
         * reset the fast pointer and look for second intersection
         */
        fast = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

}
