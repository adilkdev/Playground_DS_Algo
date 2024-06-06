package com.adil.ds_algo.arrays.sorting;

/** <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">Link</a>
 */

class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int start = 0, end = n - 1, i = 0;
        while(start <= end) {
            if(Math.abs(nums[start]) > Math.abs(nums[end])) {
                res[i++] = nums[start] * nums[start];
                start++;
            } else {
                res[i++] = nums[end] * nums[end];
                end--;
            }
        }

        return reverse(res);
    }

    public int[] reverse(int[] arr) {
        int start = 0, end = arr.length-1;
        while(start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
        return arr;
    }
}
