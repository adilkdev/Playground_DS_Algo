package com.adil.ds_algo.stack.easy;

import java.util.ArrayDeque;
import java.util.Arrays;

public class NextGreaterElement {
    public void previousSmallerElement(int[] nums) {
        int n = nums.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i])
                res[stack.pop()] = nums[i];

            stack.push(i);
        }

        for (int e : res)
            System.out.print(e + ", ");
        System.out.print(stack + ", ");
    }
}
