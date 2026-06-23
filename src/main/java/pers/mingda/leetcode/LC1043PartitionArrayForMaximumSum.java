package pers.mingda.leetcode;

import java.util.Arrays;

public class LC1043PartitionArrayForMaximumSum {}

class LC1043Solution {
  public int maxSumAfterPartitioning(int[] arr, int k) {
    int[] memo = new int[arr.length];
    Arrays.fill(memo, -1);
    return maxPartitionedSum(arr, 0, 0, 0, k, memo);
  }

  private int maxPartitionedSum(
      int[] arr, int index, int localMax, int currentPartitionSize, int k, int[] memo) {
    if (index == arr.length) {
      return 0;
    }

    if (memo[index] != -1 && currentPartitionSize == 0) {
      return memo[index];
    }

    int newLocalMax = Math.max(localMax, arr[index]);
    int maxSum =
        newLocalMax * (currentPartitionSize + 1) + maxPartitionedSum(arr, index + 1, 0, 0, k, memo);

    if (currentPartitionSize + 1 < k) {
      maxSum =
          Math.max(
              maxSum,
              maxPartitionedSum(arr, index + 1, newLocalMax, currentPartitionSize + 1, k, memo));
    }

    if (currentPartitionSize == 0) {
      memo[index] = maxSum;
    }

    return maxSum;
  }
}

class LC1043DpBottomUpSolution {
  public int maxSumAfterPartitioning(int[] arr, int k) {
    int[] tabulation = new int[k];
    for (int i = arr.length - 1; i >= 0; i--) {
      int maxNum = arr[i];
      int maxSum = 0;
      for (int j = i; j < Math.min(arr.length, i + k); j++) {
        maxNum = Math.max(maxNum, arr[j]);
        int sum = (j - i + 1) * maxNum + tabulation[(j + 1) % k];
        maxSum = Math.max(maxSum, sum);
      }
      tabulation[i % k] = maxSum;
    }
    return tabulation[0];
  }
}
