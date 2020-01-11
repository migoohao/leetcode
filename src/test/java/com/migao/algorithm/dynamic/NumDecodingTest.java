package com.migao.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Test;

public class NumDecodingTest {

    @Test
    public void test() {
        NumDecoding numDecoding = new NumDecoding();
        Assert.assertEquals(3, numDecoding.numDecodings("123"));
    }
}
