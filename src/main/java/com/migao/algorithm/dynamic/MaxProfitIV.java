package com.migao.algorithm.dynamic;

public class MaxProfitIV {

    private static final int EMPTY = 0;

    private static final int HOLD = 1;

    private static final int CUR = 1;

    private static final int PRE = 0;

    private int timesLimit;

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1 || k <= 0) {
            return 0;
        }
        if (k > prices.length / 2) {
            return maxProfit(prices);
        }
        timesLimit = k;
        int dp[][][] = new int[2][timesLimit + 1][2];
        for (int i = 0; i <= timesLimit; i++) {
            dp[PRE][i][HOLD] = -prices[0];
        }
        for (int day = 1; day < prices.length; day++) {
            for (int times = 1; times <= timesLimit; times++) {
                dp[CUR][times][EMPTY] = Math.max(dp[PRE][times][EMPTY], dp[PRE][times][HOLD] + prices[day]);
                dp[CUR][times][HOLD] = Math.max(dp[PRE][times][HOLD], dp[PRE][times - 1][EMPTY] - prices[day]);
                dp[PRE][times][EMPTY] = dp[CUR][times][EMPTY];
                dp[PRE][times][HOLD] = dp[CUR][times][HOLD];
            }

        }
        return dp[CUR][timesLimit][EMPTY];
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int dp[][] = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int day = 1; day < prices.length; day++) {
            dp[day][EMPTY] = Math.max(dp[day - 1][EMPTY], dp[day - 1][HOLD] + prices[day]);
            dp[day][HOLD] = Math.max(dp[day - 1][HOLD], dp[day - 1][EMPTY] -prices[day]);
        }
        return dp[prices.length - 1][0];
    }
}
