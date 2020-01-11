package com.migao.algorithm.dynamic;

public class LengthOfLIS {

    int[] dp;

    int length = 0;

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        dp = new int[nums.length];
        dp[0] = nums[0];
        length = 1;
        for (int i = 1; i < nums.length; i++) {
            int index = findFirstBiggerOrEqual(0, length, nums[i]);
            dp[index] = nums[i];
            if (index >= length) {
                length++;
            }
        }
        return length;
    }

    private int findFirstBiggerOrEqual(int start, int end, int key) {
        if (dp[end - 1] < key) {
            return length;
        }
        if (dp[start] >= key) {
            return 0;
        }
        while(start < end) {
            int mid = (start + end) / 2;
            if (dp[mid] == key) {
                return mid;
            }
            if (dp[mid] > key) {
                 end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
