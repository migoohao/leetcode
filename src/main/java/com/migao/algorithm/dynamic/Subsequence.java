package com.migao.algorithm.dynamic;

public class Subsequence {

    private char[] tArr;

    private char[] sArr;

    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        tArr = t.toCharArray();
        sArr = s.toCharArray();
        int tIndex = 0;
        for (int i = 0; i < sArr.length; i++) {
            tIndex = find(sArr[i], tIndex);
            if (tIndex == -1) {
                return false;
            }
        }
        return true;
    }

    private int find(char c, int start) {
        for (int i = start; i < tArr.length; i++) {
            if (c == tArr[i]) {
                return i + 1;
            }
        }
        return -1;
    }
}
