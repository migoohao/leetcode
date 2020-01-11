package com.migao.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Test;

public class LengthOfLISTest {

    @Test
    public void test() {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        Assert.assertEquals(4, lengthOfLIS.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
