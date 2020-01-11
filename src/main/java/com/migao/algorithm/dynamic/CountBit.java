package com.migao.algorithm.dynamic;

public class CountBit {

    public int[] countBits(int num) {
        if (num < 0) {
            return new int[0];
        }
        int[] result = new int[num + 1];
        int thresholdNext = 1;
        int thresholdCurrent = 0;
        for (int i = 1; i < result.length ; i++) {
            if (i == thresholdNext) {
                thresholdCurrent = thresholdNext;
                thresholdNext <<= 1;
                result[i] = 1;
            }
            result[i] = result[i - thresholdCurrent] + 1;
        }
        return result;
    }
}
