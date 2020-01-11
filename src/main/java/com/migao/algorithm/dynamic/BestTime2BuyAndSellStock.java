package com.migao.algorithm.dynamic;

public class BestTime2BuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int minStock = prices[0];
        int benefit = 0;
        for (int i = 0; i < prices.length; i++) {
            int currentBenefit = prices[i] - minStock;
            benefit = Math.max(benefit, currentBenefit);
            minStock = Math.min(minStock, prices[i]);
        }
        return benefit;
    }
}
