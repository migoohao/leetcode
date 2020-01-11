package com.migao.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Test;

public class StockMaxProfitTest {

    private StockMaxProfit stockMaxProfit = new StockMaxProfit();

    @Test
    public void test1() {
        Assert.assertEquals(3, stockMaxProfit.maxProfit(new int[] {1, 3, 1, 4}, 1));
    }
}
