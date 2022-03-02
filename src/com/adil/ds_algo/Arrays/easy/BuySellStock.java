package com.adil.ds_algo.Arrays.easy;

/**
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */

public class BuySellStock {

    public int maxProfit(int[] prices) {
        int buy=Integer.MAX_VALUE,maxProfit=0;
        for(int i=0;i<prices.length;i++){
            buy=Math.min(buy,prices[i]);
            maxProfit=Math.max(maxProfit,prices[i]-buy);
        }
        return maxProfit;
    }

}
