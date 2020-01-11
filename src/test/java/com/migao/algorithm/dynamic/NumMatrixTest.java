package com.migao.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Test;

public class NumMatrixTest {

    @Test
    public void test() {
        NumMatrix numMatrix = new NumMatrix(new int[][] {{-1}});
        Assert.assertEquals(-1, numMatrix.sumRegion(0, 0, 0, 0));
    }
}
