package com.adil.ds_algo.arrays.medium;

public class MedianOfTwoSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int l = 0, r = n1; // binary search in nums1[]

        while(l <= r) {
            // if the array length is odd then we want more elements in the first array
            int m1 = (l + r) / 2; // mid in case of nums1[]
            int m2 = (n1 + n2 + 1) / 2 - m1; // this is not mid in case of nums2[]

            // [0...m1-1] left of nums1, [m1...n1-1] right of nums1
            // [0...m2-1] left of nums2, [m2...n2-1] right of nums2

            int max1 = m1 == 0 ? Integer.MIN_VALUE : nums1[m1-1];
            int max2 = m2 == 0 ? Integer.MIN_VALUE : nums2[m2-1];

            int min1 = m1 == n1 ? Integer.MAX_VALUE : nums1[m1];
            int min2 = m2 == n2 ? Integer.MAX_VALUE : nums2[m2];

            if(max1 <= min2 && max2 <= min1) {
                if((n1 + n2) % 2 == 0)
                    return (double)(Math.max(max1, max2) + Math.min(min1, min2)) / 2;
                else
                    return Math.max(max1, max2);
            } else if(max1 > min2) {
                r = m1 - 1;
            } else {
                l = m1 + 1;
            }
        }
        return 0.0;
    }

}
