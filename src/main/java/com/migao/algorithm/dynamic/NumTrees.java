package com.migao.algorithm.dynamic;

public class NumTrees {

    private int[] dp;

    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int k = 0; k < i; k++) {
                sum += dp[k] * dp[i - k - 1];
            }
            dp[i] = sum;
        }
        return dp[n];
    }
}
