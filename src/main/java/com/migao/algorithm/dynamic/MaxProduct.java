package com.migao.algorithm.dynamic;

public class MaxProduct {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int iMax = 1; // why iMax and iMin must be start with 1 ?
        int iMin = 1; //
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = iMax;
                iMax = iMin;
                iMin = tmp;
            }
            iMax = Math.max(iMax * nums[i], nums[i]);
            iMin = Math.min(iMin * nums[i], nums[i]);
            max = Math.max(iMax, max);
        }
        return max;
    }
}
