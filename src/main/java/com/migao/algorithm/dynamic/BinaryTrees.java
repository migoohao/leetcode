package com.migao.algorithm.dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x) {
 * val = x; } }
 */

public class BinaryTrees {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<List<TreeNode>> dp = new ArrayList<>();

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        for (int i = 0; i <= n; i++) {
            List<TreeNode> trees = generate(i);
            dp.add(trees);
        }
        return dp.get(n);
    }

    public List<TreeNode> generate(int i) {
        List<TreeNode> result = new ArrayList<>();
        if (i <= 0) {
            result.add(null);
            return result;
        }
        for (int k = 1; k <= i; k++) {
            int left = k - 1;
            int right = i - k;
            int offset = k;
            for (int m = 0; m < dp.get(left).size(); m++) {
                for (int n = 0; n < dp.get(right).size(); n++) {
                    TreeNode tree = new TreeNode(k);
                    tree.left = dp.get(left).get(m);
                    tree.right = clone(dp.get(right).get(n), offset);
                    result.add(tree);
                }
            }
        }
        return result;
    }

    private TreeNode clone(TreeNode treeNode, int offset) {
        if (Objects.isNull(treeNode)) {
            return null;
        }
        TreeNode result = new TreeNode(treeNode.val + offset);
        result.left = clone(treeNode.left, offset);
        result.right = clone(treeNode.right, offset);
        return result;
    }
}
