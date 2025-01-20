package com.adil.ds_algo.arrays.general.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i < n-3; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < n-2; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1;
                int l = n-1;
                while(k < l) {
                    long x = nums[i];
                    x += nums[j];
                    x += nums[k];
                    x += nums[l];
                    if(x < target) {
                        k++;
                    } else if(x == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                        while(k < l && nums[k] == nums[k+1]) k++;
                        while(k < l && nums[l] == nums[l-1]) l--;
                        k++; l--;
                    } else {
                        l--;
                    }
                }
            }
        }
        return res;
    }

}
