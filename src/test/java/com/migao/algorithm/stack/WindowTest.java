package com.migao.algorithm.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class WindowTest {

    @Test(expected = RuntimeException.class)
    public void exceptionTest() {
        new Window(new int[] {1}, 2);
    }

    @Test
    public void oneElementTest() {
        Window window = new Window(new int[] {1}, 1);

        List<Integer> result = window.run();
        Assert.assertEquals(Arrays.toString(new int[] {1}), result.toString());
    }

    @Test
    public void runTest() {
        Window window = new Window(new int[] {4, 3, 5, 4, 3, 3, 6, 7}, 3);

        List<Integer> result = window.run();
        Assert.assertEquals(Arrays.toString(new int[] {5, 5, 5, 4, 6, 7}), result.toString());
    }
}
