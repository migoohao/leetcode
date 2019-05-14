package com.migao.algorithm.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.EmptyStackException;

public class MinStackTest {

    private MinStack minStack = new MinStack();

    @Test(expected = EmptyStackException.class)
    public void getEmptyMinTest() {
        minStack.getMin();
    }

    @Test(expected = EmptyStackException.class)
    public void popEmptyTest() {
        minStack.pop();
    }

    @Test(expected = NullPointerException.class)
    public void pushNullTest() {
        minStack.push(null);
    }

    @Test
    public void greaterTest() {
        minStack.push(1);
        minStack.push(2);

        Assert.assertEquals(1, minStack.getMin());
        Assert.assertEquals(2, minStack.stackSize());
        Assert.assertEquals(1, minStack.minStackSize());

        Assert.assertEquals(2, minStack.pop());

        Assert.assertEquals(1, minStack.getMin());
        Assert.assertEquals(1, minStack.stackSize());
        Assert.assertEquals(1, minStack.minStackSize());

        Assert.assertEquals(1, minStack.pop());

        Assert.assertEquals(0, minStack.stackSize());
        Assert.assertEquals(0, minStack.minStackSize());
    }

    @Test
    public void sameTest() {
        minStack.push(1);
        minStack.push(1);

        Assert.assertEquals(1, minStack.getMin());
        Assert.assertEquals(2, minStack.stackSize());
        Assert.assertEquals(2, minStack.minStackSize());

        Assert.assertEquals(1, minStack.pop());

        Assert.assertEquals(1, minStack.getMin());
        Assert.assertEquals(1, minStack.stackSize());
        Assert.assertEquals(1, minStack.minStackSize());

        Assert.assertEquals(1, minStack.pop());

        Assert.assertEquals(0, minStack.stackSize());
        Assert.assertEquals(0, minStack.minStackSize());
    }

    @Test
    public void smallerTest() {
        minStack.push(2);
        minStack.push(1);

        Assert.assertEquals(1, minStack.getMin());
        Assert.assertEquals(2, minStack.stackSize());
        Assert.assertEquals(2, minStack.minStackSize());

        Assert.assertEquals(1, minStack.pop());

        Assert.assertEquals(2, minStack.getMin());
        Assert.assertEquals(1, minStack.stackSize());
        Assert.assertEquals(1, minStack.minStackSize());

        Assert.assertEquals(2, minStack.pop());

        Assert.assertEquals(0, minStack.stackSize());
        Assert.assertEquals(0, minStack.minStackSize());
    }
}
