package com.adil.ds_algo.arrays.medium;

/**
 * https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1#
 *
 * testcase: [-1, 1, -1, 1]
 */

import java.util.HashMap;

class LongestSubArraySumZero
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxLength = 0;
        int sum = 0;
        map.put(sum, -1);

        for(int i=0; i<n; i++) {
            sum += arr[i];
            if (map.get(sum) != null) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }
}
