package com.migao.algorithm.dynamic;

public class MaxProfitIII {

    private static final int EMPTY = 0;

    private static final int HOLD = 1;

    private static final int TIMES_LIMIT = 2;

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int dp[][][] = new int[prices.length][TIMES_LIMIT][2];
        dp[0][0][1] = -prices[0];
        dp[0][1][1] = -prices[0];
        for (int day = 1; day < prices.length; day++) {
            for (int times = 0; times < TIMES_LIMIT; times++) {
                dp[day][times][EMPTY] = Math.max(dp[day - 1][times][EMPTY], dp[day - 1][times][HOLD] + prices[day]);
                int pre = 0;
                if (times > 0) {
                    pre = dp[day - 1][times - 1][EMPTY];
                }
                dp[day][times][HOLD] = Math.max(dp[day - 1][times][HOLD], pre - prices[day]);
            }
        }
        return Math.max(dp[prices.length - 1][0][EMPTY], dp[prices.length - 1][1][EMPTY]);
    }
}
