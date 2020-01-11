package com.migao.algorithm.dynamic;

public class MaxProfit {

    private static final int EMPTY = 0;

    private static final int HOLD = 1;

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int dp[][] = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int day = 1; day < prices.length; day++) {
            dp[day][EMPTY] = Math.max(dp[day - 1][EMPTY], dp[day - 1][HOLD] + prices[day]);
            dp[day][HOLD] = Math.max(dp[day - 1][HOLD], -prices[day]);
        }
        return dp[prices.length - 1][0] > 0 ? dp[prices.length - 1][0] : 0;
    }
}
