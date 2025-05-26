package pers.mingda.leetcode;

public class LC0055JumpGame {

  public boolean canJumpReversed(int[] nums) {
    int currentAt = nums.length - 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      int step = nums[i];
      if (i + step >= currentAt) currentAt = i;
    }

    return currentAt == 0;
  }

  public boolean canJump(int[] nums) {
    int currentAt = 0;
    for (int i = 0; i < nums.length; i++) {
      int step = nums[i];
      if (currentAt < i) return false;
      currentAt = Math.max(currentAt, i + step);
    }
    return true;
  }
}
