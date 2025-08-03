package pers.mingda.leetcode;

public class LC0041FirstMissingPositive {}

class LC0041Solution {

  public int firstMissingPositive(int[] nums) {
    int len = nums.length;
    boolean hasNumsLen = false;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      hasNumsLen = hasNumsLen || num == len;
      if (num <= 0 || num >= len || num == i) {
        continue;
      } else if (num < i) {
        nums[num] = num;
      } else if (num != nums[num]) {
        swap(nums, i, num);
        i--;
      }
    }
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != i) {
        return i;
      }
    }
    return hasNumsLen ? len + 1 : len;
  }

  private void swap(int[] nums, int index1, int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
  }
}
