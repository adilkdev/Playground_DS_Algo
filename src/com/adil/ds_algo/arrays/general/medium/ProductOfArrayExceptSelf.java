package com.adil.ds_algo.arrays.general.medium;

/**
 * url: leetcode.com/problems/product-of-array-except-self/submissions/

 * Notes :
 Naive approach: multiply all the elements to get a product and then divide the product with the current element.
 * Issues with this:
 * 1. We will have to deal with if zeros are present.
 * 2. The product might go above some range we need to look for that edge case.

 Optimal approach:
 * Use a left prefix array and a right suffix array, for a given index use left elements product
 * from left prefix array and right elements product from right suffix array.
 */

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = nums[0];
        for(int i = 1; i < n; i++)
            left[i] = left[i-1] * nums[i];

        right[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--)
            right[i] = nums[i] * right[i+1];

        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            if(i == 0)
                res[i] = right[i+1];
            //  res[i] = right[1];
            else if(i == n-1)
                res[i] = left[i-1];
            //  res[i] = left[n-2];
            else
                res[i] = left[i-1] * right[i+1];
        }

        return res;
    }

    public int[] productExceptSelfSpaceOptimised(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // create prefix array in res itself
        res[0] = 1;
        for(int i = 1; i < n; i++) {
            res[i] = nums[i-1] * res[i-1];
        }

        // create suffix and multiply to get the ans
        int suffix = 1;
        for(int i = n-2; i >= 0; i--) {
            suffix = suffix * nums[i+1];
            res[i] = res[i] * suffix; // res[i] contains prefix value
        }

        return res;
    }

}
