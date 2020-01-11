package com.migao.algorithm.dynamic;

public class MaximalSquare {

    private int[][] dp;

    public int maximalSquare(char[][] matrix) {
        if (!isValidMatrix(matrix)) {
            return 0;
        }
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        int maximalLength = 0;
        for (int row = 1; row <= matrix.length; row++) {
            for (int col = 1; col <= matrix[0].length; col++) {
                if (matrix[row - 1][col - 1] =='1') {
                    dp[row][col] = Math.min(Math.min(dp[row - 1][col], dp[row][col - 1]), dp[row - 1][col - 1]) + 1;
                    maximalLength = Math.max(maximalLength, dp[row][col]);
                }
            }
        }
        return maximalLength * maximalLength;
    }

    private boolean isValidMatrix(char[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == null) {
                return false;
            }
            if (matrix[i].length <= 0 || matrix[i].length != matrix[0].length) {
                return false;
            }
        }
        return true;
    }
}
