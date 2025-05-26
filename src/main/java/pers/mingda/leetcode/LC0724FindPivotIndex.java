package pers.mingda.leetcode;

public class LC0724FindPivotIndex {

  public int pivotIndex(int[] nums) {
    int sum = 0;
    for (int num : nums) sum += num;
    int leftSum = 0;
    for (int i = 0; i < nums.length; i++) {
      int rightSum = sum - nums[i] - leftSum;
      if (leftSum == rightSum) return i;
      leftSum += nums[i];
    }
    return -1;
  }
}
