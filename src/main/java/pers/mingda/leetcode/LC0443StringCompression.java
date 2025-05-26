package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC0443StringCompression {
  public int compress(char[] chars) {
    int sameCharCount = 1;
    char prev = chars[0];
    List<Character> result = new ArrayList<>();
    for (int i = 1; i < chars.length; i++) {
      if (chars[i] == prev) {
        sameCharCount++;
      } else {
        merge(sameCharCount, prev, result);
        sameCharCount = 1;
      }
      prev = chars[i];
    }
    merge(sameCharCount, prev, result);
    for (int i = 0; i < result.size(); i++) {
      chars[i] = result.get(i);
    }
    return result.size();
  }

  private void merge(int sameCharCount, char prev, List<Character> result) {
    result.add(prev);
    if (sameCharCount == 1) {
      return;
    }
    List<Character> duplicates = new ArrayList<>();
    while (sameCharCount != 0) {
      char c = (char) ((sameCharCount % 10) + '0');
      duplicates.addFirst(c);
      sameCharCount /= 10;
    }
    result.addAll(duplicates);
  }
}
