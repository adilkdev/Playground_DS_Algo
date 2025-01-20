package com.adil.ds_algo.recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {
        int[] arr = {1, 1};
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sums = new ArrayList<>();
//        powersetNoDuplicates(arr, 0, res, new ArrayList<>(), 0, sums);
        powerset(arr, 0, res, new ArrayList<>(), 0, sums);

        for(List<Integer> list: res) {
            System.out.print("[ ");
            for (int e: list) {
                System.out.print(e+" ");
            }
            System.out.println("]");
        }

        System.out.println();
        System.out.println();
        System.out.println();

        for (int e: sums) {
            System.out.print(e+",");
        }
    }

    public static void powerset(int[] arr, int index, List<List<Integer>> res, List<Integer>ds, int sum, List<Integer>sums) {
        if (index == arr.length) {
            res.add(new ArrayList<>(ds));
            sums.add(sum);
            return;
        }

        ds.add(arr[index]);
        powerset(arr, index+1, res, ds, sum+arr[index], sums);
        ds.remove(ds.size()-1);
        powerset(arr, index+1, res, ds, sum, sums);
    }

    public static void powersetNoDuplicates(int[] arr, int index, List<List<Integer>> res, List<Integer>ds, int sum, List<Integer>sums) {
        res.add(new ArrayList<>(ds));

        for(int i = index; i < arr.length; i++) {
            if(i != index && arr[i] == arr[i-1]) continue;

            ds.add(arr[index]);
            powerset(arr, index+1, res, ds, sum+arr[index], sums);
            ds.remove(ds.size()-1);
        }
    }

}
