package com.migao.algorithm.dynamic;

public class StoneGame {

    private int[][] dp;

    public boolean stoneGame(int[] piles) {
        dp = new int[piles.length][piles.length];
        for (int i = 0; i < piles.length; i++) {
            int k = 0;
            int m = k + i;
            while(k < piles.length && m < piles.length) {
                if (k == m) {
                    dp[k][m] = piles[k];
                } else if (((m - k) & 1) == 0) {
                    dp[k][m] = Math.min(dp[k + 1][m] - piles[k], dp[k][m - 1] - piles[m]);
                } else {
                    dp[k][m] = Math.max(dp[k + 1][m] + piles[k], dp[k][m - 1] + piles[m]);
                }
                k++;
                m++;
            }
        }
        return dp[0][piles.length - 1] > 0;
    }
}
