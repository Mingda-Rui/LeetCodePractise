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

class LC0410TabulationSolution {

  public int splitArray(int[] nums, int k) {
    int len = nums.length;
    int[] prefixSum = new int[len];
    for (int i = 0; i < len; i++) {
      prefixSum[i] = (i == 0 ? 0 : prefixSum[i - 1]) + nums[i];
    }

    int[][] memo = new int[k + 1][len];
    for (int i = 1; i <= k; i++) {
      for (int j = 0; j <= len - i; j++) {
        int minimumLargestSum = Integer.MAX_VALUE;
        if (i == 1) {
          memo[i][j] = prefixSum[len - 1] - (j == 0 ? 0 : prefixSum[j - 1]);
          continue;
        }

        for (int z = j; z <= len - i; z++) {
          int leftMostSum = prefixSum[z] - (j == 0 ? 0 : prefixSum[j - 1]);
          int largestSum = Math.max(leftMostSum, memo[i - 1][z + 1]);
          minimumLargestSum = Math.min(minimumLargestSum, largestSum);
          if (leftMostSum >= largestSum) {
            break;
          }
        }

        memo[i][j] = minimumLargestSum;
      }
    }
    return memo[k][0];
  }
}

class Solution {

  public int splitArray(int[] nums, int k) {
    int[] prefixSum = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      prefixSum[i] = (i == 0 ? 0 : prefixSum[i - 1]) + nums[i];
    }
    return findLargestSum(k, prefixSum);
  }

  private int findLargestSum(int k, int[] prefixSum) {
    int len = prefixSum.length;
    int head = 0;
    int tail = prefixSum[len - 1];
    while (head < tail) {
      int mid = (head + tail) / 2;
      if (canSplitWork(k, mid, prefixSum)) {
        tail = mid;
      } else {
        head = mid + 1;
      }
    }
    return head;
  }

  private boolean canSplitWork(int k, int splitSize, int[] prefixSum) {
    int index = 0;
    int prevIndex = -1;
    while (index < prefixSum.length && k > 0) {
      int size = prefixSum[index] - (prevIndex == -1 ? 0 : prefixSum[prevIndex]);
      if (size <= splitSize) {
        index++;
      } else {
        prevIndex = index - 1;
        k--;
      }
    }
    return index == prefixSum.length;
  }
}
