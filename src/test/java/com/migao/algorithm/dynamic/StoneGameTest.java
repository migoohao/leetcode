package com.migao.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Test;

public class StoneGameTest {

    private StoneGame stoneGame = new StoneGame();

    @Test
    public void test1() {
        Assert.assertTrue(stoneGame.stoneGame(new int[] {5, 3, 4, 5}));
    }
}
