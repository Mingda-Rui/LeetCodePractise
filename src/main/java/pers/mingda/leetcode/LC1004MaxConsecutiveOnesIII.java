package pers.mingda.leetcode;

public class LC1004MaxConsecutiveOnesIII {
  public int longestOnes(int[] nums, int k) {
    int head;
    int tail = 0;
    for (head = 0; head < nums.length; head++) {
      if (nums[head] == 0) {
        k--;
      }

      if (k < 0) {
        int offset = nums[tail] == 0 ? 1 : 0;
        k += offset;
        tail++;
      }
    }

    return head - tail;
  }
}
