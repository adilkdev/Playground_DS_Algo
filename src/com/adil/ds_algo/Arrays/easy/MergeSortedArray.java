package com.adil.ds_algo.Arrays.easy;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mIndex = 0, nIndex = 0, i=0;
        int[] res = new int[m+n];

        if(n == 0)
            return;

        while(mIndex < m && nIndex < n) {
            if(nums1[mIndex] < nums2[nIndex] ) {
                res[i] = nums1[mIndex++];
            } else {
                res[i] = nums2[nIndex++];
            }
            i++;
        }

        while(mIndex < m) {
            res[i++] = nums1[mIndex++];
        }

        while(nIndex < n) {
            res[i++] = nums2[nIndex++];
        }

        for(i=0; i<nums1.length; i++)
            nums1[i] = res[i];
    }

}
