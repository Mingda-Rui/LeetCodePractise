package pers.mingda.leetcode;

import java.util.Arrays;

public class LC0312BurstBalloons {

  public int maxCoins(int[] nums) {
    int len = nums.length;
    int[][] memo = new int[len][len];
    for (int[] row : memo) {
      Arrays.fill(row, -1);
    }
    return maxCoinsSegement(nums, 0, len - 1, memo);
  }

  private int maxCoinsSegement(int[] nums, int left, int right, int[][] memo) {
    if (left > right) {
      return 0;
    }

    if (memo[left][right] != -1) {
      return memo[left][right];
    }

    if (left == right) {
      int max = calc(nums, left, right, left);
      memo[left][right] = max;
      return max;
    }

    if (isSameNumSubArray(nums, left, right)) {
      int num = nums[left];
      int len = right - left + 1;
      int max = len * num * num * num;
      memo[left][right] = max;
      return max;
    }

    int max = 0;
    for (int i = left; i <= right; i++) {
      int sum = 0;
      sum += maxCoinsSegement(nums, left, i - 1, memo);
      sum += maxCoinsSegement(nums, i + 1, right, memo);
      sum += calc(nums, left, right, i);

      max = Math.max(max, sum);
    }
    memo[left][right] = max;
    return max;
  }

  private boolean isSameNumSubArray(int[] nums, int left, int right) {
    int first = nums[left];
    int start = Math.max(left - 1, 0);
    int end = Math.min(right + 1, nums.length - 1);
    for (int i = start; i <= end; i++) {
      if (nums[i] != first) {
        return false;
      }
    }
    return true;
  }

  private int calc(int[] nums, int left, int right, int index) {
    int leftMost = left - 1 >= 0 ? nums[left - 1] : 1;
    int rightMost = right + 1 < nums.length ? nums[right + 1] : 1;
    return leftMost * nums[index] * rightMost;
  }

  public int maxCoinsTabulation(int[] nums) {
    int len = nums.length;
    int[][] memo = new int[len][len];
    for (int left = len - 1; left >= 0; left--) {
      for (int right = left; right < len; right++) {
        int max = 0;
        for (int i = left; i <= right; i++) {
          int leftMax = (left > i - 1) ? 0 : memo[left][i - 1];
          int rightMax = (i + 1 > right) ? 0 : memo[i + 1][right];

          int leftEdge = left - 1 >= 0 ? nums[left - 1] : 1;
          int rightEdge = right + 1 < len ? nums[right + 1] : 1;
          int currentPoints = leftEdge * nums[i] * rightEdge;
          max = Math.max(max, leftMax + rightMax + currentPoints);
        }
        memo[left][right] = max;
      }
    }
    return memo[0][len - 1];
  }
}
