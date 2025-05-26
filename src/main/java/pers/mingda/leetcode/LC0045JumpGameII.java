package pers.mingda.leetcode;

public class LC0045JumpGameII {
  public int jump(int[] nums) {
    return countJump(nums, 0, 1, 0);
  }

  private int countJump(int[] nums, int start, int end, int jumpCount) {
    if (end >= nums.length) {
      return jumpCount;
    }
    int max = start;
    for (int i = start; i < end; i++) {
      max = Math.max(max, i + nums[i]);
    }
    return countJump(nums, end, max + 1, jumpCount + 1);
  }
}
