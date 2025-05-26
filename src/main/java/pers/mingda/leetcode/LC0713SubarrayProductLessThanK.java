package pers.mingda.leetcode;

public class LC0713SubarrayProductLessThanK {
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    int counter = 0;
    int slow = 0;
    int fast = 0;
    int product = 1;

    while (fast < nums.length) {
      int nextProduct = product * nums[fast];
      if (nextProduct < k || slow == fast) {
        product = nextProduct;
        fast++;
        if (product < k) counter += fast - slow;
      } else {
        product /= nums[slow];
        slow++;
      }
    }
    return counter;
  }
}
