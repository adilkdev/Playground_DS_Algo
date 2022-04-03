package com.adil.ds_algo.arrays.medium;

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
