package com.migao.algorithm.dynamic;

public class StockMaxProfit {

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int minBuyIndex = 0;
        int sellIndex =  -1;
        int incomeSum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) { //up
                int mergeSell = sellIndex != -1 ? prices[i] - prices[sellIndex] : 0;
                int oneMoreSell = prices[i] - prices[minBuyIndex] - fee;
                int maxSell = Math.max(mergeSell, oneMoreSell);
                if (maxSell > 0) {
                    incomeSum += maxSell;
                    sellIndex = i;
                    minBuyIndex = i + 1;
                }
            } else { //flat or down
                if (prices[i] < prices[minBuyIndex]) {
                    minBuyIndex = i;
                }
            }
        }
        return incomeSum;
    }
}
