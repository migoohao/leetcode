package com.migao.algorithm.dynamic;

import java.util.Arrays;

public class MinFallingPathSum {

    private int[] dp;

    public int minFallingPathSum(int[][] A) {
        if (A == null) {
            return 0;
        }
        dp = Arrays.copyOf(A[0], A[0].length);
        for (int i = 1; i < A.length; i++) {
            updateDp(A[i]);
        }
        return findArrayMin(dp);
    }

    private int findArrayMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }

    private void updateDp(int[] arr) {
        int[] ndp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int left = (i - 1) < 0 ? Integer.MAX_VALUE : dp[i - 1];
            int middle = dp[i];
            int right = (i + 1) >= arr.length ? Integer.MAX_VALUE : dp[i + 1];
            ndp[i] = Math.min(Math.min(left, middle), right) + arr[i];
        }
        System.arraycopy(ndp, 0, dp, 0, dp.length);
    }
}
