package com.migao.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Test;

public class CoinChangeTest {

    @Test
    public void test() {
        CoinChange coinChange = new CoinChange();
        Assert.assertEquals(-1, coinChange.coinChange(new int[]{2}, 3));
    }
}
