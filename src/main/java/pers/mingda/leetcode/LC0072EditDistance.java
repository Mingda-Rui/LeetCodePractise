package pers.mingda.leetcode;

import java.util.Arrays;

public class LC0072EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }
        return findMinDistance(word1, 0, word2, 0, memo);
    }

    private int findMinDistance(String word1, int i1, String word2, int i2, int[][] memo) {
        if (i2 == word2.length()) {
            return word1.length() - i1;
        }
        if (i1 == word1.length()) {
            return word2.length() - i2;
        }

        if (memo[i1][i2] != -1) {
            return memo[i1][i2];
        }

        int dist = Integer.MAX_VALUE;

        boolean matched = word1.charAt(i1) == word2.charAt(i2);
        int replaceOrMatchOffset = matched ? 0 : 1;
        dist = Math.min(dist, findMinDistance(word1, i1 + 1, word2, i2 + 1, memo) + replaceOrMatchOffset);
        dist = Math.min(dist, findMinDistance(word1, i1 + 1, word2, i2, memo) + 1);
        dist = Math.min(dist, findMinDistance(word1, i1, word2, i2 + 1, memo) + 1);

        memo[i1][i2] = dist;
        return dist;
    }
}
