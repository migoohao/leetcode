package com.migao.algorithm.dynamic;

public class SubPalindromeCount {

    private boolean[][] dp;

    public int countSubstrings(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        return buildAndCount(s.toCharArray());
    }

    private int buildAndCount(char[] chars) {
        int sum = 0;
        dp = new boolean[chars.length][chars.length];
        for (int c = 0; c < chars.length; c++) {
            for (int col = c, row = 0; col < chars.length; col++, row++) {
                if (chars[row] == chars[col] && (row == col || row + 1 > col - 1 || dp[row + 1][col - 1])) {
                    dp[row][col] =true;
                    sum ++;
                }
            }
        }
        return sum;
    }
}
