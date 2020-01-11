package com.migao.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Test;

public class EditDistanceTest {

    private EditDistance editDistance = new EditDistance();

    @Test
    public void test1() {
        int result = editDistance.minDistance("ordopj", "rduhyt");
        Assert.assertEquals(5, result);
    }
}
