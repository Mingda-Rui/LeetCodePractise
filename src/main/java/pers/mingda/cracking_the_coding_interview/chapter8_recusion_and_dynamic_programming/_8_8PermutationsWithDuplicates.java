package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _8_8PermutationsWithDuplicates {

  public List<String> calculatePerms(String str) {
    Map<Character, Integer> charCount = builcCountMap(str);
    return getPerms(charCount, str.length());
  }

  private Map<Character, Integer> builcCountMap(String str) {
    Map<Character, Integer> charCount = new HashMap<>();
    for (char c : str.toCharArray()) {
      charCount.put(c, charCount.getOrDefault(c, 0) + 1);
    }
    return charCount;
  }

  private List<String> getPerms(
    Map<Character, Integer> charCount,
    int remains
  ) {
    if (remains == 0) {
      return List.of("");
    }

    List<String> allPerms = new ArrayList<>();
    for (char c : charCount.keySet()) {
      int count = charCount.get(c);
      charCount.put(c, count - 1);
      List<String> subPerms = getPerms(charCount, remains - 1);
      charCount.put(c, count);
      List<String> newPerms = subPerms.stream().map(subP -> c + subP).toList();
      allPerms.addAll(newPerms);
    }
    return allPerms;
  }
}
