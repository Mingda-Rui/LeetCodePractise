package pers.mingda.leetcode;

import java.util.Arrays;

public class LC1498NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
}

class LC1498Solution {
  public int numSubSeq(int[] nums, int target) {
    Arrays.sort(nums);
    int modulo = 1_000_000_007;
    int[] powers = calculatePowers(nums.length, modulo);

    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      int right = binarySearchRightMost(nums, i, target - nums[i]);
      if (i <= right) {
        result = (result + powers[right - i]) % modulo;
      }
    }
    return result;
  }

  private int[] calculatePowers(int digits, int modulo) {
    int[] powers = new int[digits];
    powers[0] = 1;
    for (int i = 1; i < digits; i++) {
      powers[i] = powers[i - 1] * 2 % modulo;
    }
    return powers;
  }

  private int binarySearchRightMost(int[] nums, int start, int target) {
    int end = nums.length;
    while (start < end) {
      int mid = (start + end) / 2;
      if (nums[mid] > target) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return start - 1;
  }
}

class LC1498TwoPointersSolution {
  public int numSubSeq(int[] nums, int target) {
    Arrays.sort(nums);
    int modulo = 1_000_000_007;
    int[] powers = calculatePowers(nums.length, modulo);
    int left = 0;
    int right = nums.length - 1;
    int result = 0;
    while (left <= right) {
      if (nums[left] + nums[right] <= target) {
        result = (result + powers[right - left]) % modulo;
        left++;
      } else {
        right--;
      }
    }
    return result;
  }

  private int[] calculatePowers(int digits, int modulo) {
    int[] powers = new int[digits];
    powers[0] = 1;
    for (int i = 1; i < digits; i++) {
      powers[i] = powers[i - 1] * 2 % modulo;
    }
    return powers;
  }
}