package com.migao.algorithm.dynamic;

public class MinimumDeleteSum {

    private int dp[][];

    public int minimumDeleteSum(String s1, String s2) {
        if (s1.length() <= 0) {
            return totalSum(s2);
        }
        if (s2.length() <= 0) {
            return totalSum(s1);
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        dp = new int[arr1.length + 1][arr2.length + 1];
        buildDp(arr1, arr2);
        return dp[arr1.length][arr2.length];
    }

    private void buildDp(char[] arr1, char[] arr2) {
        for (int i = 0; i < dp.length; i++) {
            for (int k = 0; k < dp[i].length; k++) {
                if (i == 0 && k == 0) {
                    dp[i][k] = 0;
                } else if (i == 0) {
                    dp[i][k] = dp[i][k - 1] + arr2[k - 1];
                } else if (k == 0) {
                    dp[i][k] = dp[i - 1][k] + arr1[i - 1];
                } else if (arr1[i - 1] == arr2[k - 1]) {
                    dp[i][k] = dp[i - 1][k - 1];
                } else {
                    dp[i][k] = Math.min(dp[i - 1][k] + arr1[i - 1], dp[i][k - 1] + arr2[k - 1]);
                }
            }
        }
    }

    private int totalSum(String s) {
        char[] arr = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
