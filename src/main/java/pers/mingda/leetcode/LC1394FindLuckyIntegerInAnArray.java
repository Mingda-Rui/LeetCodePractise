package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC1394FindLuckyIntegerInAnArray {}

class LC1394Solution {

  public int findLucky(int[] arr) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : arr) {
      int count = freq.getOrDefault(num, 0);
      freq.put(num, count + 1);
    }

    int max = -1;
    for (int key : freq.keySet()) {
      if (key == freq.get(key)) {
        max = Math.max(key, max);
      }
    }
    return max;
  }
}
