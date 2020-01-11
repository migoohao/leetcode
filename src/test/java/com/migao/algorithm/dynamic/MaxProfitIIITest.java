package com.migao.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Test;

public class MaxProfitIIITest {

    @Test
    public void test() {
        MaxProfitIII maxProfitIII = new MaxProfitIII();
        Assert.assertEquals(4, maxProfitIII.maxProfit(new int[]{1,2,3,4,5}));
    }
}
