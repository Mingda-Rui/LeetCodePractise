package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0137SingleNumberII {}

class Solution {

  public int singleNumber(int[] nums) {
    Map<Integer, Integer> counter = new HashMap<>();
    for (int num : nums) {
      int count = counter.getOrDefault(num, 0);
      counter.put(num, count + 1);
    }
    for (int num : counter.keySet()) {
      if (counter.get(num) == 1) {
        return num;
      }
    }
    return 0;
  }
}
