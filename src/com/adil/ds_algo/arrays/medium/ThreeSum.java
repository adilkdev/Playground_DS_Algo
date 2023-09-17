package com.adil.ds_algo.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /**
     * two pointer approach
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length-2; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) {
                int l = i + 1;
                int h = nums.length-1;
                int sum = 0 - nums[i];

                while(l < h) {
                    int tempSum = nums[l] + nums[h];
                    if(tempSum < sum) l++;
                    else if(tempSum == sum) {
                        res.add(Arrays.asList(nums[i], nums[l], nums[h]));
                        while(l < h && nums[l] == nums[l+1]) l++;
                        while(l < h && nums[h] == nums[h-1]) h--;
                        l++; h--;
                    } else h--;
                }
            }
        }

        return res;
    }
}
