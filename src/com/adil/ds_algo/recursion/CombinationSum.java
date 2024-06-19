package com.adil.ds_algo.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * TC: 2 ^ target * k
 * 2 ^ target because we are selecting every index any number of times, if we were to select only once,
 * then it would be 2 ^ n, where n is the size of array.
 * k = time taken to add List<Integer> to List<List<Integer>>
 */

public class CombinationSum {

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        var list = combinationSum(arr, 7);
        System.out.println(list);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        util(0, candidates, target, res, new ArrayList<>());
        return res;
    }

    public static void util(int index, int[] nums, int target, List<List<Integer>> ans, List<Integer> ds) {
        if(index == nums.length) {
            if(target == 0)
                ans.add(new ArrayList(ds));
            return;
        }

        if(nums[index] <= target) {
            ds.add(nums[index]);
            util(index, nums, target-nums[index], ans, ds);
            ds.remove(ds.size()-1);
        }
        util(index+1, nums, target, ans, ds);
    }

}
