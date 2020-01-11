package com.migao.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Test;

public class BestTime2BuyAndSellStockTest {

    private BestTime2BuyAndSellStock bestTime2BuyAndSellStock = new BestTime2BuyAndSellStock();

    @Test
    public void test1() {
        int[] arr = new int[] {7, 1, 5, 3, 6, 4};
        Assert.assertEquals(5, bestTime2BuyAndSellStock.maxProfit(arr));
    }

    @Test
    public void show() {
        System.out.println("Cm1Wghzd".hashCode());
        System.out.println("cm1wghZD".hashCode());
    }
}
