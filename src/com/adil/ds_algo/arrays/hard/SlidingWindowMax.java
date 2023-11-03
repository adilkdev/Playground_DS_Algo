package com.adil.ds_algo.arrays.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMax {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int i = 0, n = nums.length, j = 0;
        int[] res = new int[n-k+1];
        for(; i < k; i++) {
            while(!q.isEmpty() && nums[i] > q.peekLast())
                q.removeLast();
            q.addLast(nums[i]);
        }

        for(; i < n; i++) {
            res[j++] = q.peek();

            if(nums[i-k] == q.peek()) q.removeFirst();

            while(!q.isEmpty() && nums[i] > q.peekLast()) q.removeLast();

            q.addLast(nums[i]);
        }
        res[j] = q.peek();

        return res;
    }

}
