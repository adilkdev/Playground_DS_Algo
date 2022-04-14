package com.adil.ds_algo.arrays.medium;

/**
 * https://leetcode.com/problems/powx-n/submissions/
 * solution : https://youtu.be/l0YC3876qxg
 */

public class Powxn {

    public double myPow(double x, int n) {
        double ans = 1.0;
        long tempN = n;

        if (tempN<0) tempN = -1*tempN;

        while(tempN > 0) {
            if(tempN % 2 == 0) {
                x = x * x;
                tempN /= 2;
            } else {
                ans = ans * x;
                tempN--;
            }
        }

        if (n < 0)
            return 1.0 / ans;
        else
            return ans;
    }

}
