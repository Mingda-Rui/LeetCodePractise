package pers.mingda.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC0136SingleNumber {}

class LC0136Solution {
  public int singleNumber(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (set.contains(num)) set.remove(num);
      else set.add(num);
    }
    return set.stream().findAny().get();
  }
}

class XorSolution {
  public int singleNumber(int[] nums) {
    int result = 0;
    for (int num : nums) result ^= num;
    return result;
  }
}
