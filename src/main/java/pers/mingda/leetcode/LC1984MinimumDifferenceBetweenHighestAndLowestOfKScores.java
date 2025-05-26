package pers.mingda.leetcode;

import java.util.Arrays;

public class LC1984MinimumDifferenceBetweenHighestAndLowestOfKScores {

  public int minimumDifference(int[] nums, int k) {
    Arrays.sort(nums);
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length - k + 1; i++) {
      int diff = nums[i + k - 1] - nums[i];
      min = Math.min(min, diff);
    }
    return min;
  }
}
