package com.adil.ds_algo.arrays.searching.medium;

/**
 <a href="https://leetcode.com/problems/peak-index-in-a-mountain-array/">Problem Link</a>
 */

public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int ans = -1;
        int start = 0;
        int end = arr.length-1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(arr[mid] < arr[mid+1]) {
                ans = mid + 1;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

}
