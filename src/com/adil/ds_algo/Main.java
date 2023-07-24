package com.adil.ds_algo;

import com.adil.ds_algo.arrays.easy.MoveAllZerosToEnd;
import com.adil.ds_algo.arrays.medium.MaxSubArray;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        MoveAllZerosToEnd move = new MoveAllZerosToEnd();
        int[] result = move.moveZeroes(new int[]{0,1,0,-3,12});
        Arrays.stream(result).forEach(System.out::println);
    }
}
