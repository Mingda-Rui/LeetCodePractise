package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC1133LargestUniqueNumber {}

class LC1133Solution {

  public int largestUniqueNumber(int[] nums) {
    Map<Integer, Integer> numCount = new HashMap<>();
    for (int num : nums) {
      int count = numCount.getOrDefault(num, 0);
      numCount.put(num, count + 1);
    }
    int largest = -1;
    for (int num : numCount.keySet()) {
      int count = numCount.get(num);
      if (count == 1) {
        largest = Math.max(largest, num);
      }
    }
    return largest;
  }
}
