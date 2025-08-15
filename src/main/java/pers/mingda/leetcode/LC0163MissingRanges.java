package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC0163MissingRanges {}

class LC0163Solution {

  public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
    List<List<Integer>> result = new ArrayList<>();
    int currentHead = lower;
    for (int num : nums) {
      if (num > currentHead) {
        result.add(List.of(currentHead, num - 1));
      }
      currentHead = num + 1;
    }
    if (currentHead <= upper) {
      result.add(List.of(currentHead, upper));
    }

    return result;
  }
}
