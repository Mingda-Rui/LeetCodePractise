package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC0698PartitionToKEqualSumSubsets {
}

class LC0698Solution {
  public boolean canPartitionKSubsets(int[] nums, int k) {
    int sum = Arrays.stream(nums).sum();
    if (sum % k != 0) {
      return false;
    }

    int target = sum / k;
    Set<Integer> usedIndex = new HashSet<>();

    int memoLen = 1;
    for (int i = 0; i < nums.length; i++) {
      memoLen <<= 1;
    }
    int[] memo = new int[memoLen - 1];
    return findSubsets(nums, k, 0, 0, target, usedIndex, memo);
  }

  private boolean findSubsets(int[] nums, int k, int index, int sum, int target, Set<Integer> usedIndex, int[] memo) {
    int memoKey = getMemoKey(usedIndex);
    if (memo[memoKey] != 0) {
      return memo[memoKey] == 1;
    }
    if (sum == target) {
      index = 0;
      sum = 0;
      k--;
    }
    if (k == 1) {
      return true;
    }
    if (index == nums.length) {
      memo[memoKey] = -1;
      return false;
    }

    for (int i = index; i < nums.length; i++) {
      int num = nums[i];
      if (usedIndex.contains(i) || sum + num > target) {
        continue;
      }
      usedIndex.add(i);
      if (findSubsets(nums, k, i + 1, sum + num, target, usedIndex, memo)) {
        int newMemoKey = getMemoKey(usedIndex);
        memo[newMemoKey] = 1;
        return true;
      }
      usedIndex.remove(i);
    }
    memo[memoKey] = -1;
    return false;
  }

  private int getMemoKey(Set<Integer> usedIndex) {
    int key = 0;
    for (int index : usedIndex) {
      key |= (1 << index);
    }
    return key;
  }
}
