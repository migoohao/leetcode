package com.migao.algorithm.dynamic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    private Set<String> wordSet = new HashSet<>();

    private boolean dp[];

    private int wordSizeMax;

    private int wordSizeMin;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null || wordDict.isEmpty()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        if (sArr.length <= 0) {
            return false;
        }
        initSet(wordDict);
        dp = new boolean[sArr.length + 1];
        dp[0] = true;
        for (int i = 0; i < sArr.length; i++) {
            int start = Math.max(i - wordSizeMax + 1, 0);
            int end = Math.max(i - wordSizeMin + 1, i);
            for (int k = start; k <= end ; k++) {
                if (isWordInDict(sArr, k, i) && dp[k]) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }

    private void initSet(List<String> wordDict) {
        for (String word : wordDict) {
            int size = word.length();
            wordSizeMax = Math.max(wordSizeMax, size);
            wordSizeMin = Math.min(wordSizeMin, size);
            wordSet.add(word);
        }
    }

    private boolean isWordInDict(char[] sArr, int startInclude, int endInclude) {
        int size = endInclude - startInclude + 1;
        if (size < wordSizeMin || size > wordSizeMax) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(sArr, startInclude, size);
        return wordSet.contains(stringBuilder.toString());
    }
}
