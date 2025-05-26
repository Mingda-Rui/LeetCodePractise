package pers.mingda.leetcode;

public class LC0162FindPeakElement {

  public int findPeakElement(int[] nums) {
    int start = 0;
    int end = nums.length;
    while (start < end) {
      int mid = start + (end - start) / 2;
      int val = nums[mid];
      boolean greaterThanLeft = mid == 0 || nums[mid - 1] < val;
      boolean greaterThanRight = mid == nums.length - 1 || nums[mid + 1] < val;
      if (greaterThanLeft && greaterThanRight) return mid;
      else if (!greaterThanRight) start = mid + 1;
      else end = mid;
    }

    return -1;
  }

  public int findPeakElementBruteForce(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int val = nums[i];
      boolean greaterThanLeft = i == 0 || nums[i - 1] < val;
      boolean greaterThanRight = i == nums.length - 1 || nums[i + 1] < val;
      if (greaterThanLeft && greaterThanRight) return i;
    }
    return -1;
  }
}
