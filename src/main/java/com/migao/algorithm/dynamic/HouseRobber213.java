package com.migao.algorithm.dynamic;

public class HouseRobber213 {

    private int dp[];

    public int rob(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        dp = new int[nums.length];
        return Math.max(robSub(nums, 0), robSub(nums, 1));
    }

    private int robSub(int[] nums, int start) {
        dp[0] = 0;
        dp[1] = nums[start];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[start + i - 1], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}
