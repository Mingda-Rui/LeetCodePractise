package pers.mingda.leetcode;

public class LC0189RotateArray {}

class LC0189Solution {

  public void rotate(int[] nums, int k) {
    k = k % nums.length;
    reverse(nums);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  private void reverse(int[] nums) {
    reverse(nums, 0, nums.length - 1);
  }

  private void reverse(int[] nums, int start, int end) {
    while (start < end) {
      swap(nums, start, end);
      start++;
      end--;
    }
  }

  private void swap(int[] nums, int index1, int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
  }
}
