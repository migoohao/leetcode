package com.migao.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Test;

public class DivisorGameTest {

    private DivisorGame divisorGame = new DivisorGame();

    @Test
    public void test1() {
        Assert.assertTrue(divisorGame.divisorGame(4));
    }
}
