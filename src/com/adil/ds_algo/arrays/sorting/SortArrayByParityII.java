package com.adil.ds_algo.arrays.sorting;

/**
 <a href="https://leetcode.com/problems/sort-array-by-parity-ii/description/">Link</a>
 */

class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int even = 0, odd = 1;
        for( ; even < n && odd < n; ) {
            if(nums[even] % 2 != 0 && nums[odd] % 2 == 0) {
                swap(even, odd, nums);
            } else if(nums[even] % 2 == 0) {
                even += 2;
            } else {
                odd += 2;
            }
        }

        return nums;
    }

    public void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
