package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0137SingleNumberII {}

class LC0137Solution {

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

class LC0137BitManipulationSolution {

  public int singleNumber(int[] nums) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
      int bitSum = 0;
      for (int num : nums) {
        bitSum += (num >> i) & 1;
      }
      result += (bitSum % 3) << i;
    }

    return result;
  }
}
