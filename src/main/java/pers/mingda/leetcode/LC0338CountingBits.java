package pers.mingda.leetcode;

public class LC0338CountingBits {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i < result.length; i++) result[i] = result[i / 2] + i % 2;
        return result;
    }
}
