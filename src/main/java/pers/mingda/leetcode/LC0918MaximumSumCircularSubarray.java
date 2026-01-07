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

    int max = maxSubarraySum(nums);
    int currSum = 0;
    int leftMax = Integer.MIN_VALUE;
    for (int i = 0; i < len - 2; i++) {
      currSum += nums[i];
      leftMax = Math.max(leftMax, currSum);
      max = Math.max(max, leftMax + subarraySumStartBy[i + 2]);
    }

    return max;
  }

  private int maxSubarraySum(int[] nums) {
    int currSum = 0;
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      currSum = Math.max(currSum + num, num);
      max = Math.max(max, currSum);
    }
    return max;
  }
}
