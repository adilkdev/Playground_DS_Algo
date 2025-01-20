package com.adil.ds_algo.recursion;

import com.adil.ds_algo.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> ans = new ArrayList<>();
//        permute(arr, ans, new ArrayList<>(), new boolean[arr.length]);
        permuteOptimized(arr, 0, ans);
        print(ans);
    }

    private static void print(List<List<Integer>> ans) {
        for(List<Integer> lists: ans) {
            System.out.print("[ ");
            for (Integer e: lists) {
                System.out.print(e+" ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    /**
     * here the time complexity is O(n!*n) and space complexity is O(n+n) because we are storing visited array
     */
    private static void permute(int[] arr, List<List<Integer>> ans, List<Integer> ds, boolean[] vis) {
        if(ds.size() == arr.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                ds.add(arr[i]);
                permute(arr, ans, ds, vis);
                ds.remove(ds.size()-1);
                vis[i] = false;
            }
        }
    }

    private static void permuteOptimized(int[] arr, int index, List<List<Integer>> ans) {
        if (index == arr.length) {
            List<Integer> ds = new ArrayList<>();
            for(int e: arr) ds.add(e);
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            permuteOptimized(arr, index+1, ans);
            swap(arr, index, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
