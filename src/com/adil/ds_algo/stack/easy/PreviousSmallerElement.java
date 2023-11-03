package com.adil.ds_algo.stack.easy;

import java.util.ArrayDeque;

public class PreviousSmallerElement {
    public void previousSmallerElement(int[] nums) {
        int n = nums.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && stack.peek() >= nums[i])
                stack.pop();

            if(stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(nums[i]);
        }

        for (int e : res)
            System.out.print(e + ", ");
    }
}
