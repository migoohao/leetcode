package com.migao.algorithm.dynamic;

public class NthUglyNumber {

    private int dp[];

    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        dp = new int[n];
        int last2 = 0;
        int last3 = 0;
        int last5 = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int cur2 = dp[last2] * 2;
            int cur3 = dp[last3] * 3;
            int cur5 = dp[last5] * 5;
            dp[i] = Math.min(Math.min(cur2, cur3), cur5);
            if (dp[i] == cur2) {
                last2++;
            }
            if (dp[i] == cur3) {
                last3++;
            }
            if (dp[i] == cur5) {
                last5++;
            }
        }
        return dp[n - 1];
    }
}
