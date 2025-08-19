package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC1228MissingNumberInArithmeticProgression {}

class LC1228Solution {

  public int missingNumber(int[] arr) {
    Map<Integer, Integer> diffCount = new HashMap<>();
    for (int i = 1; i < arr.length; i++) {
      int diff = arr[i] - arr[i - 1];
      int count = diffCount.getOrDefault(diff, 0);
      diffCount.put(diff, count + 1);
    }

    int diff = getDiff(diffCount);
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] - arr[i - 1] != diff) {
        return arr[i - 1] + diff;
      }
    }
    return arr[0];
  }

  private int getDiff(Map<Integer, Integer> diffCount) {
    int maxCount = 0;
    int correctDiff = 0;
    for (int diff : diffCount.keySet()) {
      int count = diffCount.get(diff);
      if (count > maxCount) {
        maxCount = count;
        correctDiff = diff;
      } else if (count == maxCount && Math.abs(diff) < Math.abs(correctDiff)) {
        correctDiff = diff;
      }
    }
    return correctDiff;
  }
}
