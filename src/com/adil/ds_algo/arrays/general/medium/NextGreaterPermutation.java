package com.adil.ds_algo.arrays.general.medium;

/**
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 *
 *     For example, for arr = [1,2,3], the following are considered permutations of arr:
 *     [1,2,3], [1,3,2], [2,1,3], [2,3,1]
 *     The next permutation of an array of integers is the next lexicographically greater permutation
 *     of its integer.
 *
 *    For example, the next permutation of arr = [1,2,3] is [1,3,2].
 *    Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 *    While the next permutation of arr = [3,2,1] is [1,2,3]
 *    because [3,2,1] does not have a lexicographical larger rearrangement.
 */

public class NextGreaterPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length == 1)
            return;
        if (nums.length == 2) {
            swap(nums, 0, 1);
            return;
        }

        int dec = nums.length - 2;
        while (dec >=0 && nums[dec] >= nums[dec + 1])
            dec--;
        reverse(nums, dec + 1, nums.length - 1);

        if (dec == -1)
            return;

        int nextNum = dec + 1;
        while (nextNum <= nums.length - 1 && nums[nextNum] <= nums[dec]) {
            nextNum++;
        }

        swap(nums, nextNum, dec);
    }

    public void swap(int []arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public void reverse(int []arr, int start, int end) {
        while(start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

}
