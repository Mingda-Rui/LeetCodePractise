package pers.mingda.leetcode;

import java.util.Arrays;

public class LC3016MinimumNumberOfPushesToTypeWordII {
}

class LC3016Solution {
  public int minimumPushes(String word) {
    int[] letterCount = new int[26];
    for (char l : word.toCharArray()) {
      int lIndex = l - 'a';
      letterCount[lIndex]++;
    }
    Arrays.sort(letterCount);

    int result = 0;
    for (int i = letterCount.length - 1; i >= 0; i--) {
      if (letterCount[i] == 0) {
        break;
      }
      int pushes = (letterCount.length - 1 - i) / 8 + 1;
      result += letterCount[i] * pushes;
    }
    return result;
  }
}