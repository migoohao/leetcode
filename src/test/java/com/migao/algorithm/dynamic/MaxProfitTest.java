package com.migao.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Test;

public class MaxProfitTest {

    @Test
    public void test() {
        MaxProfit maxProfit =  new MaxProfit();
        Assert.assertEquals(5, maxProfit.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
