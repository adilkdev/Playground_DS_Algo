package com.adil.ds_algo.arrays.general.medium;

/**
 * https://leetcode.com/problems/powx-n/submissions/
 * solution : https://youtu.be/l0YC3876qxg
 */

public class Powxn {

    /**
     * iterative approach
     */
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

    /**
     * @param x : number
     * @param n : exponent
     * @return  : number^exponent
     * recursive approach
     */
    public double myPowRec(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            return 1/x * myPow(1/x, -(n + 1));
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }

}
