package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC0760FindAnagramMappings {}

class LC0760Solution {

  public int[] anagramMappings(int[] nums1, int[] nums2) {
    int[] result = new int[nums1.length];
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < nums1.length; i++) {
      int num = nums1[i];
      map.computeIfAbsent(num, ignore -> new HashSet<>()).add(i);
    }

    for (int i = 0; i < nums2.length; i++) {
      int num = nums2[i];
      int num1Index = map.get(num).iterator().next();
      result[num1Index] = i;
      map.get(num).remove(num1Index);
    }
    return result;
  }
}
