package com.adil.ds_algo.recursion;

public class PrintSubsetSums {

    public static void main(String[] args) {
        int[] a = {2, 4, 5};
        subsetSum(a, 0, 0);
    }

    private static void subsetSum(int[] a, int idx, int sum) {
        if (idx == a.length) {
            System.out.print(sum + ", ");
            return;
        }
        subsetSum(a, idx+1, sum+a[idx]);
        subsetSum(a, idx+1, sum);
    }

}
