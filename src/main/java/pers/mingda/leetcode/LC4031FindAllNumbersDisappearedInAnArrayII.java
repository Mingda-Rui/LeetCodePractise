package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LC4031FindAllNumbersDisappearedInAnArrayII {}

class LC4031Solution {
  public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
    List<List<Integer>> result = new ArrayList<>();
    Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

    List<Integer> currentList = new ArrayList<>();

    for (int i = lower; i <= upper; i++) {
      if (!set.contains(i)) {
        if (currentList.isEmpty()) {
          currentList.add(i);
          currentList.add(i);
        } else {
          currentList.set(1, i);
        }
      } else if (set.contains(i) && !currentList.isEmpty()) {
        result.add(currentList);
        currentList = new ArrayList<>();
      }
    }

    if (!currentList.isEmpty()) {
      result.add(currentList);
    }

    return result;
  }
}
