package com.migao.algorithm.dynamic;

import java.util.HashSet;
import java.util.Set;

public class NumDecoding {
    //f(n) = ?f(n-1) + ?f(n-2)

    private static Set<String> codeSet;

    static {
        codeSet = new HashSet<>();
        for (int i = 1; i <= 26; i++) {
            codeSet.add(String.valueOf(i));
        }
    }

    public int numDecodings(String s) {
        if (s == null) {
            return 0;
        }
        char[] sArr = s.toCharArray();
        if (sArr.length <= 0) {
            return 0;
        }
        int fun1 = 0;
        int fun2 = 0;
        for (int i = 0; i < sArr.length; i++) {
            int sum = 0;
            if (codeSet.contains(String.valueOf(sArr[i]))) {
                fun1 = fun1 == 0 ? 1 : fun1;
                sum += fun1;
            }
            if (i > 0 && codeSet.contains(String.valueOf(sArr[i-1]) + String.valueOf(sArr[i]))) {
                fun2 = fun2 == 0 ? 1 : fun2;
                sum += fun2;
            }
            if (sum == 0) {
                return 0;
            }
            if (i > 0) {
                fun2 = fun1;
            }
            fun1 = sum;
        }
        return fun1;
    }
}
