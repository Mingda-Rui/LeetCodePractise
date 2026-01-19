package pers.mingda.leetcode;

public class LC0410SplitArrayLargestSum {}

class LC0410Solution {

  public int splitArray(int[] nums, int k) {
    int[][] dp = new int[k + 1][nums.length];
    int[] prefixSum = new int[nums.length];
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      prefixSum[i] = sum;
    }
    return split(nums, k, 0, dp, prefixSum);
  }

  private int split(int[] nums, int k, int index, int[][] dp, int[] prefixSum) {
    int len = nums.length;
    if (dp[k][index] != 0) {
      return dp[k][index];
    }
    if (k == 1) {
      dp[k][index] = prefixSum[len - 1] - (index == 0 ? 0 : prefixSum[index - 1]);
      return dp[k][index];
    }
    int min = Integer.MAX_VALUE;
    for (int i = index; i < nums.length - (k - 1); i++) {
      int leftSum = prefixSum[i] - (index == 0 ? 0 : prefixSum[index - 1]);
      int maxSum = Math.max(leftSum, split(nums, k - 1, i + 1, dp, prefixSum));
      min = Math.min(maxSum, min);
      if (leftSum >= maxSum) {
        break;
      }
    }
    dp[k][index] = min;
    return min;
  }
}
