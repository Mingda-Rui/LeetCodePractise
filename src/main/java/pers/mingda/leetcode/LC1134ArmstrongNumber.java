package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC1134ArmstrongNumber {}

class LC1134Solution {

  public boolean isArmstrong(int n) {
    int originalN = n;
    Map<Integer, Integer> powerRecords = new HashMap<>();
    int sum = 0;
    int power = countDigits(n);
    while (n != 0) {
      sum += doPower(n % 10, power);
      n /= 10;
      if (sum > originalN) {
        return false;
      }
    }
    return sum == originalN;
  }

  private int countDigits(int n) {
    int count = 0;
    while (n != 0) {
      n /= 10;
      count++;
    }
    return count;
  }

  private int doPower(int num, int power) {
    int result = 1;
    for (int i = 0; i < power; i++) {
      result *= num;
    }
    return result;
  }
}

class LC1134BinarySearchSolution {

  public boolean isMajorityElement(int[] nums, int target) {
    int len = nums.length;
    int halfLen = len / 2;
    int index = binarySearch(nums, target, 0, len);
    int minimumLastIndex = index + halfLen;
    return nums[index] == target && minimumLastIndex < len && nums[minimumLastIndex] == target;
  }

  private int binarySearch(int[] nums, int target, int start, int end) {
    if (start == end - 1) {
      return start;
    }
    int mid = (start + end) / 2;
    int prev = mid - 1;
    int val = nums[mid];
    if (val > target || (val == target && nums[prev] == target)) {
      end = mid;
    } else if (val < target) {
      start = mid;
    } else {
      return mid;
    }
    return binarySearch(nums, target, start, end);
  }
}
