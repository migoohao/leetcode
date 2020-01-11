package com.migao.algorithm.stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Window {

    private static final int NOT_RESULT = -1;

    private int[] arr;

    private int windowSize;

    private Deque<Integer> deque = new LinkedList<>();

    public Window(int[] arr, int size) {
        if (Objects.isNull(arr) || arr.length <= 0 || size <= 0 || arr.length < size) {
            throw new RuntimeException("constructor param error");
        }
        this.arr = arr;
        this.windowSize = size;
    }

    public List<Integer> run() {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int index = push(i);
            if (NOT_RESULT != index) {
                resultList.add(arr[index]);
            }
        }
        return resultList;
    }

    private int push(int i) {
        frontPopOld(i);
        backPushNew(i);
        return pickResult(i);
    }

    private int pickResult(int i) {
        int result = NOT_RESULT;
        if (i >= windowSize - 1) {
            result = deque.peekFirst();
        }
        return result;
    }

    private void backPushNew(int i) {
        while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) { //清除比当前小的值
            deque.pollLast();
        }
        deque.addLast(i);
    }

    private void frontPopOld(int i) {
        while (!deque.isEmpty() && deque.peekFirst() <= i - windowSize) { //清除过期
            deque.pollFirst();
        }
    }
}
