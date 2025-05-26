package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC1207UniqueNumberOfOccurrences {

  public boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : arr) {
      int val = map.getOrDefault(num, 0);
      map.put(num, val + 1);
    }

    Set<Integer> count = new HashSet<>();
    for (int num : map.keySet()) {
      int val = map.get(num);
      if (count.contains(val)) {
        return false;
      }
      count.add(val);
    }
    return true;
  }
}
