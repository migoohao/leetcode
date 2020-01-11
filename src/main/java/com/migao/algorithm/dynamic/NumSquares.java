package com.migao.algorithm.dynamic;

public class NumSquares {

    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        int[] powCache = new int [n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
            for (int j = 1; j < i; j++) {
                if (powCache[j] == 0) {
                    powCache[j] = j * j;
                }
                if (powCache[j] > i) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - powCache[j]] + 1);
            }
        }
        return dp[n];
    }
}
