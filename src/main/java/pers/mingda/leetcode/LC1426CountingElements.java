package pers.mingda.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC1426CountingElements {}

class LC1426Solution {

  public int countElements(int[] arr) {
    Set<Integer> nums = new HashSet<>();
    for (int num : arr) {
      nums.add(num);
    }
    int count = 0;
    for (int num : arr) {
      if (nums.contains(num + 1)) {
        count++;
      }
    }
    return count;
  }
}
