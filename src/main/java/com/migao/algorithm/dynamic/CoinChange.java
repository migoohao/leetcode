package com.migao.algorithm.dynamic;

public class CoinChange {

    private static final int NO_ANSWER = -1;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (coins == null || coins.length <= 0 || amount <= 0) {
            return NO_ANSWER;
        }
        int dp[] = new int[amount + 1];
        initDp(dp);
        for (int i = 1; i < dp.length; i++) {
            for (int k = 0; k < coins.length; k++) {
                int pre = i - coins[k];
                if (pre == 0) {
                    dp[i] = 1;
                }
                if (pre > 0 && dp[pre] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[pre] + 1, dp[i]);
                }
            }

        }
        return dp[amount] == Integer.MAX_VALUE ? NO_ANSWER : dp[amount];
    }

    private void initDp(int[] dp) {
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
    }
}

