package pers.mingda.leetcode;

public class LC1493LongestSubarrayOf1sAfterDeletingOneElement {
  public int longestSubarray(int[] nums) {
    int countOfZero = 0;
    int head;
    int tail = 0;
    for (head = 0; head < nums.length; head++) {
      if (nums[head] == 0) {
        countOfZero++;
      }
      if (countOfZero > 1) {
        countOfZero -= (nums[tail] == 0 ? 1 : 0);
        tail++;
      }
    }
    return head - tail - 1;
  }
}
