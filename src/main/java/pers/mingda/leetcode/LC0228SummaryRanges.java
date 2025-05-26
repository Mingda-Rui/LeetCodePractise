package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC0228SummaryRanges {}

class LC0228Solution {

  public List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    final String arrow = "->";
    int head = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i + 1 == nums.length || nums[i] + 1 != nums[i + 1]) {
        String range = head == i
          ? String.valueOf(nums[head])
          : nums[head] + arrow + nums[i];
        result.add(range);
        head = i + 1;
      }
    }
    return result;
  }
}
