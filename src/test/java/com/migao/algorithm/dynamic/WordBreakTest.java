package com.migao.algorithm.dynamic;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

public class WordBreakTest {

    @Test
    public void test() {
        WordBreak wordBreak = new WordBreak();
        boolean result = wordBreak.wordBreak("leetcode", Lists.newArrayList("leet", "code"));
        Assert.assertTrue(result);
    }
}
