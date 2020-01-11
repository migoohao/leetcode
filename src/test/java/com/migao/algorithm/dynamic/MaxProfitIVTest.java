package com.migao.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Test;

public class MaxProfitIVTest {

    @Test
    public void test() {
        MaxProfitIV maxProfitIV = new MaxProfitIV();
        Assert.assertEquals(2, maxProfitIV.maxProfit(2, new int[]{2,4,1}));
    }
}
