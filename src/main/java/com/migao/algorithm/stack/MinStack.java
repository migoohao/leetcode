package com.migao.algorithm.stack;

/*
 *设计一个有getMin方法的stack
 */

import java.util.EmptyStackException;
import java.util.Objects;
import java.util.Stack;

public class MinStack<T extends Comparable> {

    private Stack<T> stack = new Stack<>();

    private Stack<T> minStack = new Stack<>();

    public T pop() {
        if (stack.empty()) {
            throw new EmptyStackException();
        }
        T element = stack.pop();
        if (element == minStack.peek()) {
            minStack.pop();
        }
        return element;
    }

    public void push(T element) {
        if (Objects.isNull(element)) {
            throw new NullPointerException();
        }
        stack.push(element);
        if (minStack.empty() || element.compareTo(minStack.peek()) <= 0) {
            minStack.push(element);
        }
    }

    public T getMin() {
        if (minStack.empty()) {
            throw new EmptyStackException();
        }
        return minStack.peek();
    }

    public int stackSize() {
        return stack.size();
    }

    public int minStackSize() {
        return minStack.size();
    }
}
