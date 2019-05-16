package com.migao.algorithm.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Hanoi {

    private static final String LEFT = "left";

    private static final String RIGHT = "right";

    private static final String MIDDLE = "middle";

    private Stack<Integer> left = new Stack<>();

    private Stack<Integer> middle = new Stack<>();

    private Stack<Integer> right = new Stack<>();

    private Map<String, Stack<Integer>> nameMap = new HashMap<>();

    private String lastStack;

    private Integer lastNum;

    private long times = 0;

    private static Map<String, String[]> directions = new HashMap<>();

    static {
        directions.put(LEFT, new String[] {MIDDLE});
        directions.put(MIDDLE, new String[] {LEFT, RIGHT});
        directions.put(RIGHT, new String[] {MIDDLE});
    }

    public Hanoi(int num) {
        if (num <= 0) {
            throw new RuntimeException("num:" + num + " should be greater than 0");
        }
        nameMap.put(LEFT, left);
        nameMap.put(MIDDLE, middle);
        nameMap.put(RIGHT, right);
        for (int i = 0; i < num; i++) {
            left.push(num - i);
        }
        lastStack = LEFT;
        lastNum = 0;
    }

    public void run() {
        printAllStack();
        if (isFinished()) {
            return;
        }
        recursiveMove(left.size(), LEFT, RIGHT);
        printTimes();
    }

    public void iterRun() {
        printAllStack();
        while (!isFinished()) {
            directions.forEach((k, v) -> {
                for (String target : v) {
                    if (canMove(k, target) && !isRollBackStep(k, target)) {
                        directMove(k, target);
                        return;
                    }
                }
            });
        }
        printTimes();
    }

    private void recursiveMove(int num, String from, String to) {
        if (num <= 1) {
            move(from, to);
            return;
        }
        recursiveMove(num - 1, from, to);
        move(from, MIDDLE);
        recursiveMove(num - 1, to, from);
        move(MIDDLE, to);
        recursiveMove(num - 1, from, to);
    }

    private void move(String from, String to) {
        if (MIDDLE.equals(from) || MIDDLE.equals(to)) {
            directMove(from, to);
        } else {
            directMove(from, MIDDLE);
            directMove(MIDDLE, to);
        }
    }

    private void directMove(String from, String to) {
        Stack<Integer> fromStack = nameMap.get(from);
        Stack<Integer> toStack = nameMap.get(to);
        if (canMove(from, to)) {
            Integer value = fromStack.pop();
            lastStack = from;
            lastNum = value;
            System.out.println(value + ":" + from + " -> " + to);
            toStack.push(value);
            printAllStack();
            times++;
            return;
        }
        throw new RuntimeException(from + ":" + fromStack.toString() + " -> " + to + ":" + toStack.toString());
    }

    private boolean canMove(String from, String to) {
        return !nameMap.get(from).empty()
            && (nameMap.get(to).empty() || nameMap.get(to).peek() > nameMap.get(from).peek());
    }

    private boolean isRollBackStep(String from, String to) {
        return lastStack.equals(to) && lastNum.equals(nameMap.get(from).peek());
    }

    private void printAllStack() {
        System.out.println(LEFT + ":" + left.toString());
        System.out.println(MIDDLE + ":" + middle.toString());
        System.out.println(RIGHT + ":" + right.toString());
    }

    private boolean isFinished() {
        return left.empty() && middle.empty();
    }

    private void printTimes() {
        System.out.println("total move times:" + times);
    }
}
