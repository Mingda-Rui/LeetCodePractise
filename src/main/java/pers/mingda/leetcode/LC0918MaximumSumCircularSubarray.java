package pers.mingda.leetcode;

public class LC0918MaximumSumCircularSubarray {}

class LC0918Solution {

  public int maxSubarraySumCircular(int[] nums) {
    int len = nums.length;
    int[] subarraySumStartBy = new int[len];
    int rightSum = 0;
    int rightMax = Integer.MIN_VALUE;
    for (int i = len - 1; i >= 0; i--) {
      rightSum += nums[i];
      rightMax = Math.max(rightMax, rightSum);
      subarraySumStartBy[i] = rightMax;
    }

    int leftSum = 0;
    int leftMax = Integer.MIN_VALUE;
    int circularMax = Integer.MIN_VALUE;

    int currSum = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < len; i++) {
      if (i < len - 2) {
        leftSum += nums[i];
        leftMax = Math.max(leftMax, leftSum);
        circularMax = Math.max(circularMax, leftMax + subarraySumStartBy[i + 2]);
      }

      currSum = Math.max(currSum + nums[i], nums[i]);
      max = Math.max(max, currSum);
    }

    return Math.max(max, circularMax);
  }
}
