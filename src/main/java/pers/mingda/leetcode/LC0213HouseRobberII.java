package pers.mingda.leetcode;

public class LC0213HouseRobberII {
  public int rob(int[] nums) {
    if (nums.length < 2) return nums[0];
    int max1 = rob(nums, 0, nums.length - 1);
    int max2 = rob(nums, 1, nums.length);
    return Math.max(max1, max2);
  }

  private int rob(int[] nums, int start, int finish) {
    int beforePrev = 0;
    int prev = 0;
    for (int i = start; i < finish; i++) {
      int val = nums[i] + beforePrev;
      beforePrev = prev;
      prev = Math.max(prev, val);
    }
    return prev;
  }
}
