package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC0229MajorityElementII {}

class LC0229Solution {

  public List<Integer> majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      int count = map.getOrDefault(num, 0);
      map.put(num, count + 1);
    }
    List<Integer> result = new ArrayList<>();

    int n = nums.length;
    for (int num : map.keySet()) {
      if (map.get(num) > n / 3) {
        result.add(num);
      }
    }

    return result;
  }
}
