package pers.mingda.leetcode;

public class LC0643MaximumAverageSubarrayI {
  public double findMaxAverage(int[] nums, int k) {
    double max = 0;
    double current = 0;
    for (int i = 0; i < nums.length; i++) {
      current += nums[i];
      if (i == k - 1) {
        max = current;
      }
      if (i >= k) {
        current -= nums[i - k];
      }
      max = Math.max(max, current);
    }
    return max / k;
  }
}
