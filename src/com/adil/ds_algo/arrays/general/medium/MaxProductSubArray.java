package com.adil.ds_algo.arrays.general.medium;

/**
 * url: leetcode.com/problems/maximum-product-subarray
 *
 * notes
 * Case 1: All numbers are positive
 *
 * Case 2: Positive and negative numbers in input
 * a. event count of negative numbers
 * b. odd count of negative numbers.
 * we need to take care of this one only,
 * if we remove one -ve number, it'll become event count of +ve numbers which will give us max answer.
 *
 * Case 3: Positive, negative and zero
 */

public class MaxProductSubArray {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        double ans  = nums[0];
        double leftProduct = 1;
        double rightProduct = 1;

        for(int i = 0; i < n; i++) {
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            leftProduct *= (double) nums[i];
            rightProduct *= (double) nums[n-i-1];
            ans = Math.max(ans, Math.max(leftProduct, rightProduct));
        }

        return (int) ans;
    }

}
