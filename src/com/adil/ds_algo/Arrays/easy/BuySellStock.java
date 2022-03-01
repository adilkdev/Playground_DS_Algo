package com.adil.ds_algo.Arrays.easy;

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
