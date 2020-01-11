package com.migao.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Test;

public class SubsequenceTest {

    private Subsequence subsequence = new Subsequence();

    @Test
    public void test1() {
        Assert.assertTrue(subsequence.isSubsequence("", "abcde"));
    }

    @Test
    public void test2() {
        Assert.assertTrue(subsequence.isSubsequence("", ""));
    }
}
