package com.migao.algorithm.stack;

import org.junit.Test;

public class HanoiTest {

    @Test(expected = RuntimeException.class)
    public void createErrorTest() {
        new Hanoi(0);
    }

    @Test
    public void oneTest() {
        Hanoi hanoi = new Hanoi(1);
        hanoi.run();
    }

    @Test
    public void twoTest() {
        Hanoi hanoi = new Hanoi(2);
        hanoi.run();
    }

    @Test
    public void threeTest() {
        Hanoi hanoi = new Hanoi(3);
        hanoi.run();
    }

    @Test
    public void oneIterRun() {
        Hanoi hanoi = new Hanoi(1);
        hanoi.iterRun();
    }

    @Test
    public void twoIterTest() {
        Hanoi hanoi = new Hanoi(2);
        hanoi.iterRun();
    }

    @Test
    public void threeIterTest() {
        Hanoi hanoi = new Hanoi(3);
        hanoi.iterRun();
    }
}
