package pers.mingda.leetcode;

import java.util.Arrays;

public class LC0300LongestIncreasingSubsequence {
  public int lengthOfLIS(int[] nums) {
    int[] record = new int[nums.length];
    int globalMax = 0;
    for (int i = 0; i < nums.length; i++) {
      int max = 0;
      for (int j = 0; j < i; j++) if (nums[j] < nums[i]) max = Math.max(max, record[j]);
      record[i] = max + 1;
      globalMax = Math.max(globalMax, record[i]);
    }
    return globalMax;
  }

  public int lengthOfLISBinarySearch(int[] nums) {
    int[] record = new int[nums.length];
    int counter = 0;
    record[counter] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int val = nums[i];
      int index = findReplaceIndex(record, 0, counter + 1, val);
      counter = Math.max(counter, index);
      record[index] = val;
    }

    return counter + 1;
  }

  private int findReplaceIndex(int[] record, int start, int finish, int val) {
    int index = Arrays.binarySearch(record, start, finish, val);
    return index >= 0 ? index : -index - 1;
  }
}
