package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC1502CanMakeArithmeticProgressionFromSequence {
}

class LC1502SortingSolution {
  public boolean canMakeArithmeticProgression(int[] arr) {
    Arrays.sort(arr);
    for (int i = 1; i + 1 < arr.length; i++) {
      if (arr[i] - arr[i - 1] != arr[i + 1] - arr[i]) {
        return false;
      }
    }
    return true;
  }
}

class LC1502SetSolution {
  public boolean canMakeArithmeticProgression(int[] arr) {
    Set<Integer> set = new HashSet<>();

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (int num : arr) {
      set.add(num);

      min = Math.min(min, num);
      max = Math.max(max, num);
    }
    if (set.size() == 1) {
      return true;
    }
    if (set.size() != arr.length) {
      return false;
    }

    if ((max - min) % (arr.length - 1) != 0) {
      return false;
    }
    int diff = (max - min) / (arr.length - 1);
    for (int num : arr) {
      if ((num - min) % diff != 0) {
        return false;
      }
    }
    return true;
  }
}