package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC3016MinimumNumberOfPushesToTypeWordII {
}

class LC3016Solution {
  public int minimumPushes(String word) {
    Map<Character, Integer> letterCount = new HashMap<>();
    for (char l : word.toCharArray()) {
      int count = letterCount.getOrDefault(l, 0);
      letterCount.put(l, count + 1);
    }
    Comparator<Map.Entry<Character, Integer>> comparator = Comparator.<Map.Entry<Character, Integer>>comparingInt(Map.Entry::getValue).reversed();
    List<Map.Entry<Character, Integer>> sorted = letterCount.entrySet().stream().sorted(comparator).toList();

    Map<Character, Integer> pushCount = new HashMap<>();
    for (int i = 0; i < sorted.size(); i++) {
      Map.Entry<Character, Integer> entry = sorted.get(i);
      pushCount.put(entry.getKey(), i / 8 + 1);
    }

    int result = 0;
    for (char c : word.toCharArray()) {
      result += pushCount.get(c);
    }
    return result;
  }
}