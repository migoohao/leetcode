package com.migao.algorithm.dynamic;

public class EditDistance {

    private char[] word1;

    private char[] word2;

    private int[][] dp;

    public int minDistance(String word1, String word2) {
        this.word1 = word1.toCharArray();
        this.word2 = word2.toCharArray();
        this.dp = new int[this.word1.length + 1][this.word2.length + 1];
        buildDp();
        return this.dp[this.word1.length][this.word2.length];
    }

    private void buildDp() {
        for (int w1 = 0; w1 < dp.length; w1++) {
            for (int w2 = 0; w2 < dp[w1].length; w2++) {
                if (w1 == 0) {
                    dp[w1][w2] = w2;
                } else if (w2 == 0) {
                    dp[w1][w2] = w1;
                } else if (word1[w1 - 1] == word2[w2 - 1]) {
                    dp[w1][w2] = dp[w1 - 1][w2 - 1];
                } else {
                    dp[w1][w2] = Math.min(Math.min(dp[w1 - 1][w2], dp[w1][w2 - 1]), dp[w1 - 1][w2 - 1]) + 1;
                }
            }
        }
    }
}
