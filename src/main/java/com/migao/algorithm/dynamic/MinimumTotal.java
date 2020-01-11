package com.migao.algorithm.dynamic;

import java.util.List;

public class MinimumTotal {

    private int[] dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        dp = new int[triangle.get(triangle.size() - 1).size() + 1];
        for (int i = triangle.size() - 1; i >= 0 ; i--) {
            List<Integer> level = triangle.get(i);
            for (int k = 0; k < level.size(); k++) {
                dp[k] = Math.min(dp[k], dp[k + 1]) + level.get(k);
            }
        }
        return dp[0];
    }
}
