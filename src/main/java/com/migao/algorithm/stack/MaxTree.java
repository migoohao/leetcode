package com.migao.algorithm.stack;

import java.util.Objects;

public class MaxTree {

    public class Node {

        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    static public void print(Node tree) {
        postPrint(tree);
        System.out.println();
    }

    static public void postPrint(Node tree) {
        if (Objects.isNull(tree)) {
            return;
        }
        System.out.print(tree.value);
        postPrint(tree.left);
        postPrint((tree.right));
    }
}
