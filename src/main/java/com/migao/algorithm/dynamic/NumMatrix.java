package com.migao.algorithm.dynamic;

public class NumMatrix {

    private int[][] dp;

    private int row;

    private int col;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            dp = new int[0][0];
            row = 0;
            col = 0;
            return;
        }
        dp = new int[matrix.length][matrix[0].length];
        row = matrix.length;
        col = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[0].length; k++) {
                int left = k - 1;
                int up = i - 1;
                int leftNum = left >= 0 ? dp[i][left] : 0;
                int upNum = up >= 0 ? dp[up][k] : 0;
                int leftUpNum = left >= 0 && up >= 0 ? dp[up][left] : 0;
                dp[i][k] = leftNum + upNum - leftUpNum + matrix[i][k];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 >= row || row2 >= row || col1 >= col || col2 >= col || row1 > row2 || col1 > col2 || row1 < 0 || col1 < 0) {
            return 0;
        }
        row1--;
        col1--;
        int upNum = row1 >= 0 ?  dp[row1][col2] : 0;
        int leftNum = col1 >= 0 ? dp[row2][col1] : 0;
        int upLeftNum = (row1 >= 0 && col1 >= 0) ? dp[row1][col1] : 0;
        return dp[row2][col2] - upNum - leftNum + upLeftNum;
    }
}
