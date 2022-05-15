package pers.mingda.leetcode;

public class LC0300LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] record = new int[nums.length];
        int globalMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++)
                if (nums[j] < nums[i])
                    max = Math.max(max, record[j]);
            record[i] = max + 1;
            globalMax = Math.max(globalMax, record[i]);
        }
        return globalMax;
    }
}
