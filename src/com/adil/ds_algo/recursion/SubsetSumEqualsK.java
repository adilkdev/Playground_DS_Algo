package com.adil.ds_algo.recursion;

class SubsetSumEqualsK {
    public static void main(String[] args) {
        int[] nums = {3,2,1,3};
        int target = 6;
        System.out.println("ans : "+subseq(nums, 0, 0, target, 0));
    }

    public static int subseq(int[] nums, int index, int sum, int target, int count) {
        if(index == nums.length) {
            return sum == target ? count + 1 : count;
        }

        int x = subseq(nums, index+1, sum+nums[index], target, count);
        int y = subseq(nums, index+1, sum, target, count);
        return x+y;
    }
}
