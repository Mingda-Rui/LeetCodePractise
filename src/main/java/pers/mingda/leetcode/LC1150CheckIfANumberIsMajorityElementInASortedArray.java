package pers.mingda.leetcode;

public class LC1150CheckIfANumberIsMajorityElementInASortedArray {}

class LC1150Solution {

  public boolean isMajorityElement(int[] nums, int target) {
    int majority = nums.length / 2;
    int count = 0;
    for (int num : nums) {
      if (num == target) {
        count++;
        if (count > majority) {
          return true;
        }
      }
      if (num > target) {
        return false;
      }
    }
    return false;
  }
}
