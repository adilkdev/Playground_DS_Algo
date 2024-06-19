package com.adil.ds_algo.recursion;

import java.util.ArrayList;
import java.util.List;

class ListSubsets {

    public static void main(String[] args) {
        int[] nums = {1};
        List<List<Integer>> ans = subsets(nums);
        for(List<Integer> lists: ans) {
            System.out.print("[ ");
            for (Integer e: lists) {
                System.out.print(e+" ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        util(nums, 0, list, subset);
        return list;
    }

    public static void util(int[] nums, int index, List<List<Integer>> list, List<Integer> subset) {
        if(index == nums.length) {
            list.add(subset);
            return;
        }
        subset.add(nums[index]);
        util(nums, index+1, list, subset);
        subset.remove(subset.size()-1);
        util(nums, index+1, list, subset);
    }

}
