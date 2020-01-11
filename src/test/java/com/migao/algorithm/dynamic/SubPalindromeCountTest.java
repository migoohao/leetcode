package com.migao.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Test;

public class SubPalindromeCountTest {

    private SubPalindromeCount subPalindromeCount = new SubPalindromeCount();

    @Test
    public void test1() {
        Assert.assertEquals(6, subPalindromeCount.countSubstrings("aaa"));
    }
}
