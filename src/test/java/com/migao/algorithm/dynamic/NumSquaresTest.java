package com.migao.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Test;

public class NumSquaresTest {

    @Test
    public void test() {
        NumSquares numSquares = new NumSquares();
        Assert.assertEquals(3, numSquares.numSquares(12));
    }
}
