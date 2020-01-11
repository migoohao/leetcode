package com.migao.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Test;

public class NumArrayTest {

    private NumArray numArray = new NumArray(new int[]{-2,0,3,-5,2,-1});

    @Test
    public void test1() {
        Assert.assertEquals(1, numArray.sumRange(0,2));
    }

    @Test
    public void test2() {
        Assert.assertEquals(-1, numArray.sumRange(2,5));
    }

    @Test
    public void test3() {
        Assert.assertEquals(-3, numArray.sumRange(0,5));
    }
}
