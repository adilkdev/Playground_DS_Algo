package com.adil.ds_algo.arrays.searching.medium;

/**
 <a href="https://leetcode.com/problems/find-peak-element/">Problem Link</a>
 */

public class PeakIndex {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n-1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(
                    (mid == 0 || nums[mid] > nums[mid-1]) &&
                            (mid == n-1 || nums[mid] > nums[mid+1])
            ) {
                return mid;
            } else if(nums[mid] < nums[mid+1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

}
