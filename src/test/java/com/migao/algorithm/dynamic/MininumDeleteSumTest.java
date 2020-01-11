package com.migao.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Test;

public class MininumDeleteSumTest {

    private MinimumDeleteSum minimumDeleteSum = new MinimumDeleteSum();

    @Test
    public void test1() {
        Assert.assertEquals(231, minimumDeleteSum.minimumDeleteSum("sea", "eat"));
    }
}
