package com.migao.algorithm.dynamic;

public class MaxProfit309 {

    private static final int HOLD = 1;

    private static final int EMPTY = 0;

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int dp[][] = new int[prices.length][2];
        dp[0][HOLD] = - prices[0];
        for (int i = 1; i < prices.length; i++) {
            int pre = i - 1;
            int beforePre = i - 2;
            if (beforePre < 0) {
                beforePre = 0;
            }
            dp[i][HOLD] = Math.max(dp[pre][HOLD], dp[beforePre][EMPTY] - prices[i]);
            dp[i][EMPTY] = Math.max(dp[pre][EMPTY], dp[pre][HOLD] + prices[i]);
        }
        return dp[prices.length - 1][EMPTY];
    }
}
