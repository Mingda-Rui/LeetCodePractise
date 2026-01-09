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

class LC0229BoyerMooreSolution {

  public List<Integer> majorityElement(int[] nums) {
    List<Integer> result = new ArrayList<>();
    int candidate1 = 0;
    int candidate2 = 0;
    int count1 = 0;
    int count2 = 0;

    for (int num : nums) {
      if (count1 != 0 && candidate1 == num) {
        count1++;
      } else if (count2 != 0 && candidate2 == num) {
        count2++;
      } else if (count1 == 0) {
        candidate1 = num;
        count1++;
      } else if (count2 == 0) {
        candidate2 = num;
        count2++;
      } else {
        count1--;
        count2--;
      }
    }

    boolean hasCandidate1 = count1 != 0;
    boolean hasCandidate2 = count2 != 0;
    count1 = 0;
    count2 = 0;
    for (int num : nums) {
      if (hasCandidate1 && num == candidate1) count1++;
      else if (hasCandidate2 && num == candidate2) count2++;
    }
    if (count1 > nums.length / 3) {
      result.add(candidate1);
    }
    if (count2 > nums.length / 3) {
      result.add(candidate2);
    }

    return result;
  }
}
