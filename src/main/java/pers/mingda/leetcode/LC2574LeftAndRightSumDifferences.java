package pers.mingda.leetcode;

public class LC2574LeftAndRightSumDifferences {}

class LC2574Solution {
  public int[] leftRightDifference(int[] nums) {
    int len = nums.length;

    int[] rightSum = new int[nums.length];
    rightSum[len - 1] = 0;
    for (int i = len - 2; i >= 0; i--) {
      rightSum[i] = rightSum[i + 1] + nums[i + 1];
    }

    int leftSum = 0;
    int[] result = new int[len];
    for (int i = 0; i < len; i++) {
      result[i] = Math.abs(leftSum - rightSum[i]);
      leftSum += nums[i];
    }
    return result;
  }
}
